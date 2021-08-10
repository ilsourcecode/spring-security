package com.lyw.mapper;

import com.lyw.entities.SysRole;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysRoleMapper {

  List<SysRole> selectRolesByUserId(@Param("userid") Integer userid);
}
