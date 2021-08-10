package com.lyw.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

import javax.sql.DataSource;

@Configuration
public class ApplicationConfig {

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean(name = "userDetailsService")
  public UserDetailsService userDetailsService(DataSource dataSource, PasswordEncoder pe) {
    JdbcUserDetailsManager manager = new JdbcUserDetailsManager(dataSource);
    // 判断当前 admin 用户是否存在，存在的话不添加
    if (!manager.userExists("admin")) {
      // 默认是往数据库中添加信息，因为 username  是主键不能重复添加，所以会报错
      manager.createUser(User.withUsername("admin")
              .password(pe.encode("123"))
              .roles("ADMIN","USER","MANAGER").build());
    }
    if (!manager.userExists("normal")) {
      manager.createUser(User.withUsername("normal")
              .password(pe.encode("123"))
              .roles("USER").build());
    }

    return manager;
  }
}
