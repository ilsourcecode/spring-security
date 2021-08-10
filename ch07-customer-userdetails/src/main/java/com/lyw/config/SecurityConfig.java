package com.lyw.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  @Qualifier("CustomUserDetailsService")
  private UserDetailsService userDetailsService;

  @Bean
  PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests()
            // 白名单
            .antMatchers("/index", "/myLogin.html", "/login", "/error.html").permitAll() // index 请求不需要认证
            .antMatchers("/tyy/**").hasRole("ADMIN")
            .antMatchers("/lyw/**").hasRole("USER")
            // 除白名单之外其他的请求都拦截
            .anyRequest().authenticated() // 其他任何一个请求都需要认证
            .and()
            // 设置登录页面
            .formLogin()
            // 自定义登录页面
            .loginPage("/myLogin.html")
            // 自定义登录页面表单提交使用到的 Url 地址
            .loginProcessingUrl("/login")
            // 登录验证错误提示界面！
            .failureUrl("/error.html")
            .and()
            // 关闭跨域访问的安全控制，先禁用
            .csrf().disable();
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    super.configure(auth);
    auth.userDetailsService(userDetailsService);
  }
}
