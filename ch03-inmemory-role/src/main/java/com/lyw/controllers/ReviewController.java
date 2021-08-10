package com.lyw.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReviewController {

  @RequestMapping("/admin")
  @PreAuthorize("hasAnyRole('ADMIN')")
  public String doAdmin() {
    return "admin 用户能访问到的资源！";
  }


  @RequestMapping("/user")
  @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
  public String doUser() {
    return "user 能访问的资源地址！";
  }

}


/****
 *
 * @RequestMapping("/admin")
 *   @PreAuthorize("hasAnyRole('admin','user')")
 *   public String doAdmin() {
 *     return "admin 基于角色的安全框架认证！";
 *   }
 *
 *   @RequestMapping("/user")
 *   @PreAuthorize("hasAnyRole('user')")
 *   public String doUser() {
 *     return "user 基于角色的安全认证！";
 *   }
 */
