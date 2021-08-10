package com.lyw.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController {

  @GetMapping("/admin")
  @PreAuthorize("hasAnyRole('ADMIN')")
  public String doAdmin() {
    return "超级管理员能访问的资源文件！";
  }

  @GetMapping("/user")
  @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
  public String doUser() {
    return "都可以访问的资源文件！";
  }
}
