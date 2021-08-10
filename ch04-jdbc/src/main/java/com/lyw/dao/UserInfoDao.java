package com.lyw.dao;

import com.lyw.entities.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/***
 * UserInfo 是泛型对象
 * Long 是主键类型
 */
public interface UserInfoDao extends JpaRepository<UserInfo, Long> {

  UserInfo findByUsername(String username);
}
