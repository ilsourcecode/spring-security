package com.lyw.entities;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
import java.util.List;

public class SysUser implements UserDetails {

  private Integer id;
  private String username;
  private String password;
  private String realName;

  private boolean isEnable;
  private boolean isLock;
  private boolean isCredentials;
  private boolean isExpired;

  private Date createTime;
  private Date loginTime;

  private List<GrantedAuthority> authorities;

  public SysUser() {}

  public SysUser(String username, String password, String realName, boolean isEnable, boolean isLock, boolean isCredentials, boolean isExpired, Date createTime, Date loginTime, List<GrantedAuthority> authorities) {
    this.username = username;
    this.password = password;
    this.realName = realName;
    this.isEnable = isEnable;
    this.isLock = isLock;
    this.isCredentials = isCredentials;
    this.isExpired = isExpired;
    this.createTime = createTime;
    this.loginTime = loginTime;
    this.authorities = authorities;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return authorities;
  }

  @Override
  public String getPassword() {
    return password;
  }

  @Override
  public String getUsername() {
    return username;
  }

  @Override
  public boolean isAccountNonExpired() {
    return isExpired;
  }

  @Override
  public boolean isAccountNonLocked() {
    return isLock;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return isCredentials;
  }

  @Override
  public boolean isEnabled() {
    return isEnable;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getRealName() {
    return realName;
  }

  public void setRealName(String realName) {
    this.realName = realName;
  }

  public boolean isEnable() {
    return isEnable;
  }

  public void setEnable(boolean enable) {
    isEnable = enable;
  }

  public boolean isLock() {
    return isLock;
  }

  public void setLock(boolean lock) {
    isLock = lock;
  }

  public boolean isCredentials() {
    return isCredentials;
  }

  public void setCredentials(boolean credentials) {
    isCredentials = credentials;
  }

  public boolean isExpired() {
    return isExpired;
  }

  public void setExpired(boolean expired) {
    isExpired = expired;
  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  public Date getLoginTime() {
    return loginTime;
  }

  public void setLoginTime(Date loginTime) {
    this.loginTime = loginTime;
  }

  public void setAuthorities(List<GrantedAuthority> authorities) {
    this.authorities = authorities;
  }
}
