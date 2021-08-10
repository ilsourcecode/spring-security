package com.lyw.securityException;

import org.springframework.security.core.AuthenticationException;

public class VerificationException extends AuthenticationException {

  public VerificationException() {
    super("验证码错误！！");
  }

  public VerificationException(String detail) {
    super(detail);
  }

  public VerificationException(String detail, Throwable ex) {
    super(detail, ex);
  }
}
