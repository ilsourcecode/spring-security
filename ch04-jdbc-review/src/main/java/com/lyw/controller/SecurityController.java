package com.lyw.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController {

  @RequestMapping("/admin")
  @PreAuthorize("hasAnyRole('ADMIN')")
  public String doAdmin() {
    return "Admin 可以访问的资源文件地址!";
  }

  @RequestMapping("/normal")
  @PreAuthorize("hasAnyRole('NORMAL', 'ADMIN')")
  public String doNormal() {
    return "Normal、Admin 都能访问的资源文件!";
  }
}
