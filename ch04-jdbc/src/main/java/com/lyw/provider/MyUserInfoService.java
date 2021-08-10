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
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/***
 *  认证数据源
 *  自定义逻辑控制认证逻辑
 */
@Component("MyUserInfoService")
public class MyUserInfoService implements UserDetailsService {

  @Autowired
  private UserInfoDao dao;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

    UserInfo userInfo = null;
    User user = null;
    if (username != null) {
      userInfo = dao.findByUsername(username);
      if (userInfo != null) {
        List<GrantedAuthority> list = new ArrayList<>();
        // 注意添加角色的时候这里又一个 'ROLE_' 前缀
        SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority("ROLE_" + userInfo.getRoles());
        list.add(simpleGrantedAuthority);
        user = new User(userInfo.getUsername(), userInfo.getPassword(), list);
      }
    }

    return user;
  }
}
