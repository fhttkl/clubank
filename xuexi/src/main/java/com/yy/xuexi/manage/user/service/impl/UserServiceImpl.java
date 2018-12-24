package com.yy.xuexi.manage.user.service.impl;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yy.xuexi.common.redis.RedisKeyCode;
import com.yy.xuexi.common.util.CommonResult;
import com.yy.xuexi.common.util.ResultCode;
import com.yy.xuexi.manage.base.service.BaseCodeRuleService;
import com.yy.xuexi.manage.user.dao.UserMapper;
import com.yy.xuexi.manage.user.pojo.User;
import com.yy.xuexi.manage.user.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper userMapper;
	@Autowired
	private BaseCodeRuleService baseCodeRuleService;
	
	public CommonResult selectUsersByProperty(String cardNo, String name,
			String tel, Integer pageIndex, Integer pageSize) {
		// TODO Auto-generated method stub
		userMapper.selectUserByProperty();
		return null;
	}

	public CommonResult register(User user) {
		// TODO Auto-generated method stub
		//根据生产规则生产会员卡号
		user.setCardNo(baseCodeRuleService.getCode(RedisKeyCode.CARD_NO.getValue()));
		user.setCreateDate(new Date());
		user.setTotalBalance(new BigDecimal(0));
		int i=userMapper.insertUser(user);
		if(i>0){
			return CommonResult.result(ResultCode.SUCC.getValue(), "添加成功");
		}
		return CommonResult.result(ResultCode.FAIL.getValue(), "添加失败");
	}


}
