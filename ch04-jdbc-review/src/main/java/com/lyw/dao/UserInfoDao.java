package com.lyw.dao;

import com.lyw.entities.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/***
 *  UserDao 指泛型类型
 *  Long 指主键的类型
 */
public interface UserInfoDao extends JpaRepository<UserInfo, Long> {

  UserInfo findUserByUsername(String username);
}
