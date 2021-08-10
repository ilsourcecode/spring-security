package com.lyw.mapper;

import com.lyw.entities.SysUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SysUserMapper {

  int insertUser(SysUser sysUser);

  SysUser selectUserByUsername(@Param("username") String username);
}
