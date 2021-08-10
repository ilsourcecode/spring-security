package com.lyw.entities;

public class SysRole {
  private Integer id;
  private String roleName;
  private String roleDescribe;

  public SysRole() {}

  public SysRole(Integer id, String roleName, String roleDescribe) {
    this.id = id;
    this.roleName = roleName;
    this.roleDescribe = roleDescribe;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getRoleName() {
    return roleName;
  }

  public void setRoleName(String roleName) {
    this.roleName = roleName;
  }

  public String getRoleDescribe() {
    return roleDescribe;
  }

  public void setRoleDescribe(String roleDescribe) {
    this.roleDescribe = roleDescribe;
  }

  @Override
  public String toString() {
    return "SysRole{" +
            "id=" + id +
            ", roleName='" + roleName + '\'' +
            ", roleDescribe='" + roleDescribe + '\'' +
            '}';
  }
}
