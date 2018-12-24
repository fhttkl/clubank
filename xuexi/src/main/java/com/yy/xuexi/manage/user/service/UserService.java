package com.yy.xuexi.manage.user.service;

import com.yy.xuexi.common.util.CommonResult;
import com.yy.xuexi.manage.user.pojo.User;

public interface UserService {

	/**
	 * 根据会员卡号，会员姓名，会员电话分页查询会员信息
	 * @param cardNo
	 * @param name
	 * @param tel
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	public CommonResult selectUsersByProperty(String cardNo,String name,String tel,Integer pageIndex,Integer pageSize);
	
	
	/**
	 * 根据会员卡号，会员姓名，会员电话分页查询会员信息
	 * @param user
	 * @return
	 */
	public CommonResult register(User user);
	
}
