package com.lyw.service;

import com.lyw.entities.SysRole;
import com.lyw.entities.SysUser;
import com.lyw.mapper.SysRoleMapper;
import com.lyw.mapper.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("myUserDetails")
public class MyUserDetails implements UserDetailsService {

  @Autowired
  private SysUserMapper sysUserMapper;

  @Autowired
  private SysRoleMapper sysRoleMapper;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    SysUser sysUser = sysUserMapper.selectUserByUsername(username);
    if (sysUser != null) {

      List<SysRole> sysRoles = sysRoleMapper.selectRolesByUserId(sysUser.getId());

      List<GrantedAuthority> authorities = new ArrayList<>();
      for (SysRole sysRole : sysRoles) {
        GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + sysRole.getRoleName());
        authorities.add(authority);
      }

      sysUser.setAuthorities(authorities);
    }
    return sysUser;
  }
}
