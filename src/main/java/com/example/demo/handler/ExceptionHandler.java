package com.example.demo.handler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * The type Rest response entity exception handler.
 */
@RestControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {

  @Autowired
  private MessageSource messageSource;

  /**
   * Handler business exception response entity.
   *
   * @param ex the ex
   * @param request the request
   * @return the response entity
   */
  @org.springframework.web.bind.annotation.ExceptionHandler(BizException.class)
  public ErrorResponse handlerBusinessException(BizException ex,
      HttpServletRequest request) {

    List<Error> errors = new ArrayList<>();
    for (String errCode : ex.getErrCodes()) {
      String errMessage = messageSource.getMessage(errCode, null, LocaleContextHolder.getLocale());
      errors.add(new Error(errCode, errMessage));
    }

    ErrorResponse response = ErrorResponse.builder().errors(errors)
        .httpStatus(HttpStatus.OK.value()).url(request.getRequestURL().toString())
        .timestamp(LocalDateTime.now())
        .build();

    return response;
  }

}


