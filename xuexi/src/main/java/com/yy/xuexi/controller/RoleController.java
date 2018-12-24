package com.yy.xuexi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yy.xuexi.common.util.CommonResult;
import com.yy.xuexi.manage.role.service.RoleService;

@Controller
@RequestMapping(value="/role")
public class RoleController {

	@Autowired
	private RoleService roleService;
	
	@ResponseBody
	@RequestMapping(value="/listRoleByProperty",method=RequestMethod.GET)
	public CommonResult listRoleByProperty(){
		System.out.println("��ѯ�û���ɫ��Ϣ");
		return roleService.listRoleByProperty();
	}
}
