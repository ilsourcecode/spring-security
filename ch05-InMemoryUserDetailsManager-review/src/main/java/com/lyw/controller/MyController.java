package com.lyw.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

  @GetMapping("/hello")
  @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
  public String doHello() {
    return "Hello Security!";
  }
}
