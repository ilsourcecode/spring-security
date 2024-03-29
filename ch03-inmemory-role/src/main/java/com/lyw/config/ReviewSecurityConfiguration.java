package com.lyw.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ReviewSecurityConfiguration extends WebSecurityConfigurerAdapter {

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {

    PasswordEncoder pe = passwordEncoder();
    auth.inMemoryAuthentication()
            .withUser("admin").password(pe.encode("123")).roles("ADMIN", "USER")
            .and()
            .withUser("user").password(pe.encode("123")).roles("USER");
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
}

/***
 *
 * @Bean
 *   public PasswordEncoder passwordEncoder() {
 *     return new BCryptPasswordEncoder();
 *   }
 *
 *   @Override
 *   protected void configure(AuthenticationManagerBuilder auth) throws Exception {
 *     PasswordEncoder pe = passwordEncoder();
 *     auth.inMemoryAuthentication()
 *             .withUser("admin").password(pe.encode("123")).roles("admin", "user");
 *     auth.inMemoryAuthentication()
 *             .withUser("user").password(pe.encode("123")).roles("user");
 *   }
 */
