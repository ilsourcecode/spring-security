package com.lyw.handle;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lyw.vo.Result;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

@Component
public class MyFailureHandler implements AuthenticationFailureHandler {

  private Result result;

  public Result getResult() {
    return result;
  }

  public void setResult(Result result) {
    this.result = result;
  }

  @Override
  public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {

    response.setContentType("text/json;charset=UTF-8");

    if (result == null) {
      Result defaultResult = new Result();
      defaultResult.setCode(1000);
      defaultResult.setCode(1);
      defaultResult.setMeg("登录失败！");
    }

    OutputStream os = response.getOutputStream();
    ObjectMapper om = new ObjectMapper();
    om.writeValue(os, result);
    os.flush();
    os.close();
  }
}
