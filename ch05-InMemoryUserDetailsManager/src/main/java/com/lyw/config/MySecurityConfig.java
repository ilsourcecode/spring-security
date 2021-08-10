package com.lyw.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  private UserDetailsService userDetailsService;

  @Override
  /***
   *  基于 Web 安全用到的类
   */
  protected void configure(HttpSecurity http) throws Exception {
    super.configure(http);
    // 用户认证信息的类
    http.userDetailsService(userDetailsService);
  }
}
