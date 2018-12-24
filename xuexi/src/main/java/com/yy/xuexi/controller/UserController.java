package com.yy.xuexi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yy.xuexi.common.util.CommonResult;
import com.yy.xuexi.manage.user.pojo.User;
import com.yy.xuexi.manage.user.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	/**
	 * зЂВс
	 */
	@ResponseBody
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public CommonResult register(@RequestBody User user){
		CommonResult result=userService.register(user);
		return result;
	}
}
