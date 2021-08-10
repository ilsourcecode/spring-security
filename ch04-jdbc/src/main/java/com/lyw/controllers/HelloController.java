package com.lyw.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

  @GetMapping("/hello")
  public String doHello() {
    return "使用内存中的用户信息";
  }

  @RequestMapping("/auth")
  @PreAuthorize(value = "hasAnyRole('admin', 'normal')")
  public String doBothAccess() {
    return "admin , normal 两个角色都可以访问";
  }

  @RequestMapping("/admin")
  @PreAuthorize(value = "hasAnyRole('admin')")
  public String doAdmin() {
    return "只有admin能够访问的角色";
  }
}
