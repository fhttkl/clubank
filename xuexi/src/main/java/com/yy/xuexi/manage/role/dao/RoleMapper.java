package com.yy.xuexi.manage.role.dao;

import java.util.List;

import com.yy.xuexi.manage.role.pojo.Role;

public interface RoleMapper {

	public List<Role> selectRolesByProperty();
}
