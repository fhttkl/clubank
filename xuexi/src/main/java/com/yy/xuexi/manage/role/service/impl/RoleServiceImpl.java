package com.yy.xuexi.manage.role.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yy.xuexi.common.util.CommonResult;
import com.yy.xuexi.common.util.ResultCode;
import com.yy.xuexi.manage.role.dao.RoleMapper;
import com.yy.xuexi.manage.role.pojo.Role;
import com.yy.xuexi.manage.role.service.RoleService;

@Service("roleService")
public class RoleServiceImpl implements RoleService{

	@Autowired
	private RoleMapper roleMapper;

	public CommonResult listRoleByProperty() {
		List<Role> roles=roleMapper.selectRolesByProperty();
		return CommonResult.result(ResultCode.SUCC.getValue(), "≤È—Ø≥…π¶", roles);
	}
	
	
	
}
