package com.lyw.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

//@Configuration
//@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    PasswordEncoder pe = passwordEncoder();

    auth.inMemoryAuthentication()
            .withUser("陶园园")
            .password(pe.encode("1236")).roles();
    auth.inMemoryAuthentication()
            .withUser("李亚伟")
            .password(pe.encode("187016")).roles();
    auth.inMemoryAuthentication()
            .withUser("admin")
            .password(pe.encode("123456")).roles();
  }

//  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
}
