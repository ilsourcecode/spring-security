package com.lyw.provider;

import com.lyw.dao.UserInfoDao;
import com.lyw.entities.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Service("myUserInfoService")
public class MyUserInfoService implements UserDetailsService {

  @Autowired
  private UserInfoDao dao;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    UserInfo userInfo = null;
    User user = null;
    if (username != null) {
      userInfo = dao.findUserByUsername(username);
      if (!StringUtils.isEmpty(userInfo)) {
        List<GrantedAuthority> roles = new ArrayList<>();
        GrantedAuthority admin = new SimpleGrantedAuthority("ROLE_" + "ADMIN");
        roles.add(admin);
        user = new User(userInfo.getUsername(), userInfo.getPassword(), roles);
      }
    }
    return user;
  }
}
