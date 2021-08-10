package com.lyw.filter;

import com.lyw.handle.MyFailureHandler;
import com.lyw.securityException.VerificationException;
import com.lyw.vo.ResponseInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.naming.AuthenticationException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Component
public class VerificationFilter extends OncePerRequestFilter {

  @Autowired
  private MyFailureHandler failureHandler;

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

    String requestURI = request.getRequestURI();

    if ("/login".equals(requestURI)) {
      try {
        verification(request);
      } catch (VerificationException exception) {
        ResponseInfo info = new ResponseInfo();
        info.setError(10001);
        info.setCode(1);
        info.setMeg("验证码错误！");
        failureHandler.setInfo(info);
        failureHandler.onAuthenticationFailure(request, response, exception);
      }
    }

    filterChain.doFilter(request, response);
  }

  public void verification(HttpServletRequest request) throws VerificationException {
    HttpSession session = request.getSession();
    String requestCap = request.getParameter("captcha");
    Object sessionCap = session.getAttribute("captcha");

    String sessionCaptcha = "";
    if ( !StringUtils.isEmpty(sessionCap) ) {
      sessionCaptcha = (String) sessionCap;
    }

    if ( !StringUtils.isEmpty(sessionCap) ) {
      session.removeAttribute("captcha");
    }

    if ( StringUtils.isEmpty(requestCap)
            || !requestCap.equals(sessionCaptcha)) {
      throw new VerificationException();
    }
  }
}
