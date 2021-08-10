package com.lyw.filter;

import com.lyw.handle.MyFailureHandler;
import com.lyw.securityException.VerificationException;
import com.lyw.vo.Result;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/***
 *  当前过滤其准备在用户信息认证之前执行
 */
public class VerificationFiler extends OncePerRequestFilter {

  private MyFailureHandler handler = new MyFailureHandler();

  @Override
  protected void doFilterInternal(HttpServletRequest request,
                                  HttpServletResponse response,
                                  FilterChain filterChain) throws ServletException, IOException {
    String requestURI = request.getRequestURI();
    if (!"/login".equals(requestURI)) {
      filterChain.doFilter(request, response);
    } else {
      try {
        verificationCaptcha(request);
      } catch (VerificationException e) {
        Result result = new Result();
        result.setError(1002);
        result.setCode(1);
        result.setMeg("验证码错误！");
        handler.setResult(result);
        handler.onAuthenticationFailure(request, response, e);
      }
      filterChain.doFilter(request, response);
    }
  }

  private void verificationCaptcha(HttpServletRequest request) throws VerificationException {
    String requestCaptcha = request.getParameter("captcha").toUpperCase();
    System.out.println(requestCaptcha + "----------------");
    HttpSession session = request.getSession();
    Object captcha2 = session.getAttribute("captcha");

    String sessionCaptcha = "";
    if (captcha2 != null) {
      sessionCaptcha = (String) captcha2;
    }

    if (!StringUtils.isEmpty(captcha2)) {
      // 这里还没有进行用户信息认证
      // 如果执行到这说明用户已经发起了登录请求
      // session中的现在这个code就应该无用
      session.removeAttribute("captcha");
    }

    // 判断code是否正确
    if (StringUtils.isEmpty(requestCaptcha)
            || StringUtils.isEmpty(sessionCaptcha)
            || !requestCaptcha.equals(sessionCaptcha)) {
      // 失败！
      throw new VerificationException();
    }
  }
}
