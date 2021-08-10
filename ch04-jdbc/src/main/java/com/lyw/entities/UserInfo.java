package com.lyw.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

// 表示当前类是一个实体类，表示数据库中的一个表
// 表名默认是和类名一致
@Entity
public class UserInfo {

  @Id // 表示当前字段主键
  @GeneratedValue(strategy = GenerationType.IDENTITY) // 主键自增的生成方式
  private Long id;

  private String username;
  private String password;
  private String roles;

  public UserInfo() {}

  public UserInfo(Long id, String username, String password, String roles) {
    this.id = id;
    this.username = username;
    this.password = password;
    this.roles = roles;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getRoles() {
    return roles;
  }

  public void setRoles(String roles) {
    this.roles = roles;
  }

  @Override
  public String toString() {
    return "UserInfo{" +
            "id=" + id +
            ", username='" + username + '\'' +
            ", password='" + password + '\'' +
            ", roles='" + roles + '\'' +
            '}';
  }
}
