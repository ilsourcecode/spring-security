package com.lyw.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class ApplicationConfig {

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  public UserDetailsService userDetailsService() {
    PasswordEncoder pe = passwordEncoder();

    InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
    manager.createUser(User
            .withUsername("admin")
            .password(pe.encode("123"))
            .roles("ADMIN", "USER").build()
    );

    manager.createUser(User
            .withUsername("user")
            .password(pe.encode("123"))
            .roles("USER").build()
    );

    return manager;
  }
}
