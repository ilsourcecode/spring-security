package com.lyw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LocationMapperController {

  @GetMapping(value = "/admin", produces = "text/html;charset=UTF-8")
  @ResponseBody
  public String doAdmin() {
    return "admin 可以访问的资源地址！";
  }

  @GetMapping(value = "/user", produces = "text/html;charset=UTF-8")
  @ResponseBody
  public String doUser() {
    return "任何用户都可以访问的资源地址！";
  }
}
