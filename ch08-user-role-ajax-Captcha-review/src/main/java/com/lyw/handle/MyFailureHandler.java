package com.lyw.handle;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lyw.vo.ResponseInfo;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class MyFailureHandler implements AuthenticationFailureHandler {

  private ResponseInfo info;

  public ResponseInfo getInfo() {
    return info;
  }

  public void setInfo(ResponseInfo info) {
    this.info = info;
  }

  @Override
  public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
    response.setContentType("text/json;charset=UTF-8");
    ResponseInfo info = new ResponseInfo();
    info.setCode(1);
    info.setError(10001);
    info.setMeg("登录失败！");
    ServletOutputStream os = response.getOutputStream();
    ObjectMapper om = new ObjectMapper();
    om.writeValue(os, info);
    os.flush();
    os.close();
  }
}
