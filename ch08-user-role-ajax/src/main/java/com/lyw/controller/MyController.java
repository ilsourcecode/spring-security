package com.lyw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {

  @GetMapping("index")
  public String doIndex() {
    return "forward:/index.html";
  }

  @GetMapping(value = "/tyy", produces = "text/html;charset=UTF-8")
  @ResponseBody
  public String doTYY() {
    return "Admin访问成功！";
  }

  @GetMapping(value = "/lyw", produces = "text/html;charset=UTF-8")
  @ResponseBody
  public String doLyw() {
    return "User访问成功!";
  }
}
