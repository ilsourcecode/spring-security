package com.lyw.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloSecurityController {

  @RequestMapping("/security")
  public String doHello() {
    return "say hello security 安全框架！";
  }
}
