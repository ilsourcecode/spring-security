package com.lyw.handle;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lyw.vo.Result;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

@Component
public class MySuccessHandler implements AuthenticationSuccessHandler {

  @Override
  /***
   *  request 请求对象
   *  response 响应对象
   *  authentication spring security 框架用户验证成功之后的封装类
   */
  public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
    response.setContentType("text/json;charset=UTF-8");
    Result r = new Result();
    r.setCode(0);
    r.setError(1000);
    r.setMeg("登录成功！");

    OutputStream os = response.getOutputStream();
    ObjectMapper om = new ObjectMapper();
    om.writeValue(os, r);
    os.flush();
    os.close();
  }
}
