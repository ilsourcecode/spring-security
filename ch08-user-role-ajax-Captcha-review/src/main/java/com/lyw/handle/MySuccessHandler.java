package com.lyw.handle;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lyw.vo.ResponseInfo;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class MySuccessHandler implements AuthenticationSuccessHandler {

  @Override
  public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
    ResponseInfo result = new ResponseInfo();
    result.setCode(0);
    result.setError(1000);
    result.setMeg("登录成功！");
    response.setContentType("text/html;charset=UTF-8");

    ServletOutputStream os = response.getOutputStream();
    ObjectMapper om = new ObjectMapper();
    om.writeValue(os, result);

    os.flush();
    os.close();
  }
}
