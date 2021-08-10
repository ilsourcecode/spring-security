package com.lyw.init;

import com.lyw.dao.UserInfoDao;
import com.lyw.entities.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

//@Component
public class JdbcInit {

  @Autowired
  private UserInfoDao dao;

//  @PostConstruct
  public void init() {
    PasswordEncoder pe = new BCryptPasswordEncoder();
    UserInfo u = new UserInfo();

    u.setUsername("陶园园");
    u.setPassword(pe.encode("1236"));
    u.setRoles("admin");
    dao.save(u);

    u = new UserInfo();
    u.setUsername("李亚伟");
    u.setPassword(pe.encode("123456"));
    u.setRoles("normal");
    dao.save(u);
  }
}
