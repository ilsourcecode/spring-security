package com.lyw;

import com.lyw.entities.SysUser;
import com.lyw.mapper.SysUserMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@MapperScan("com.lyw.mapper")
@SpringBootApplication
public class CustomerUserDetailsApplication {

  @Autowired
  private SysUserMapper sysUserMapper;

  public static void main(String[] args) {
    SpringApplication.run(CustomerUserDetailsApplication.class, args);
  }

  // @PostConstruct
  public void test() {
    List<GrantedAuthority> authorities = new ArrayList<>();
    GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_" + "ADMIN");
    authorities.add(grantedAuthority);

    PasswordEncoder pe = new BCryptPasswordEncoder();

    Date curDate = new Date();
    SysUser sysUser1 = new SysUser(
            "陶园园", pe.encode("123"), "管理员",
            true, true, true, true, curDate,
            curDate, authorities);
    sysUserMapper.insertUser(sysUser1);

    List<GrantedAuthority> authorities2 = new ArrayList<>();
    GrantedAuthority grantedAuthority2 = new SimpleGrantedAuthority("ROLE_" + "USER");
    authorities.add(grantedAuthority2);

    SysUser sysUser2 = new SysUser(
            "李亚伟", pe.encode("123"), "普通用户",
            true, true, true, true, curDate,
            curDate, authorities2);
    sysUserMapper.insertUser(sysUser2);
  }
}
