package com.example.demo.utils;

import com.example.demo.handler.BizException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.BindingResult;

/**
 * Created by TuanPm on 2019-08-28.
 */
public class EntityValidationUtils {

  /**
   * Process binding results.
   *
   * @param bindingResult the binding result
   */
  public static void processBindingResults(BindingResult bindingResult) {
    if (bindingResult.hasErrors()) {
      List<String> errors = new ArrayList<>();
      bindingResult.getAllErrors().forEach(err -> errors.add(err.getDefaultMessage()));
      throw new BizException(errors);
    }
  }
}
