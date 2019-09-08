package com.example.demo.handler2;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BIZException extends RuntimeException {

  private String errCode;
  private ErrType errType;
  private String errMsg;

  /**
   * Instantiates a new Biz exception.
   *
   * @param errMsg the err msg
   * @param errType the err type
   */
  public BIZException(String errMsg, ErrType errType) {
    this.errMsg = errMsg;
    this.errType = errType;
  }

  /**
   * Build constraint violation exception biz exception.
   *
   * @param errMsg the err msg
   * @return the biz exception
   */
  public BIZException buildConstraintViolationException(String errMsg) {
    return getBizException(errMsg, ErrType.CONSTRAINT);
  }

  /**
   * Build resource not found exception biz exception.
   *
   * @param errMsg the err msg
   * @return the biz exception
   */
  public BIZException buildResourceNotFoundException(String errMsg) {
    return getBizException(errMsg, ErrType.NOT_FOUND);
  }

  /**
   * Build data integrity violation exception biz exception.
   *
   * @param errMsg the err msg
   * @return the biz exception
   */
  public BIZException buildDataIntegrityViolationException(String errMsg) {
    return getBizException(errMsg, ErrType.CONFLICT);
  }

  /**
   * Build unsupported operation exception biz exception.
   *
   * @param errMsg the err msg
   * @return the biz exception
   */
  public BIZException buildUnsupportedOperationException(String errMsg) {
    return getBizException(errMsg, ErrType.UNSUPPORTED_OPERATION);
  }

  /**
   * The enum Err type.
   */
  enum ErrType {
    CONSTRAINT,
    NOT_FOUND,
    CONFLICT,
    UNSUPPORTED_OPERATION
  }

  private BIZException getBizException(String errMsg, ErrType errType) {
    BIZException bizException = new BIZException(errMsg, errType);
    return bizException;

  }
}
