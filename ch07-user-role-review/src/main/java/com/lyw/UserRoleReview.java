package com.lyw;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = "com.lyw.mapper")
@SpringBootApplication
public class UserRoleReview {

  public static void main(String[] args) {
    SpringApplication.run(UserRoleReview.class, args);
  }
}
