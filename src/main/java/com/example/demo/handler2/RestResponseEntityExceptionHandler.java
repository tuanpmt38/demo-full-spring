package com.example.demo.handler2;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

  public static final String FORBIDDEN_MESSAGE = "Exception.forbidden";
  private MessageSource messageSource;

  public RestResponseEntityExceptionHandler(MessageSource messageSource) {
    this.messageSource = messageSource;
  }

  @ExceptionHandler(BIZException.class)
  public ResponseEntity<Object> handlerBusinessException(BIZException ex,
      HttpServletRequest request) {
    HttpStatus httpStatus;
    switch (ex.getErrType()) {
      case CONSTRAINT:
        httpStatus = HttpStatus.BAD_REQUEST;
        break;
      case CONFLICT:
        httpStatus = HttpStatus.CONFLICT;
        break;
      case NOT_FOUND:
        httpStatus = HttpStatus.NOT_FOUND;
        break;
      case UNSUPPORTED_OPERATION:
        httpStatus = HttpStatus.FORBIDDEN;
        break;
      default:
        httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;

    }
    List<String> errors = new ArrayList<>();
    errors.add(messageSource.getMessage(ex.getErrMsg(), null, LocaleContextHolder.getLocale()));
    OpenApiBaseResponse response = new OpenApiBaseResponse();
    response.setHttpStatus(httpStatus);
    response.setError(errors);
    response.setUrl(request.getRequestURL().toString());
    return new ResponseEntity<>(response, httpStatus);

  }

  @ExceptionHandler(org.springframework.security.access.AccessDeniedException.class)
  public ResponseEntity<Object> handleAccessDeniedException(HttpServletRequest request) {
    List<String> errors = new ArrayList<>();
    errors.add(messageSource.getMessage(FORBIDDEN_MESSAGE, null, LocaleContextHolder.getLocale()));
    OpenApiBaseResponse response = new OpenApiBaseResponse();
    response.setHttpStatus(HttpStatus.FORBIDDEN);
    response.setError(errors);
    response.setUrl(request.getRequestURL().toString());
    return new ResponseEntity<>(response, HttpStatus.FORBIDDEN);
  }
}
