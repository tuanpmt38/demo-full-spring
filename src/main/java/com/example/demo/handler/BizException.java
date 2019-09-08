package com.example.demo.handler;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The type Biz exception.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BizException extends RuntimeException {

  List<String> errCodes;

  public BizException buildException(List<String> errCodes) {
    return new BizException(errCodes);
  }

}

