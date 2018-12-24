package com.yy.xuexi.manage.user.dao;

import java.util.List;

import com.yy.xuexi.manage.role.pojo.Role;
import com.yy.xuexi.manage.user.pojo.User;

public interface UserMapper {

	public List<User> selectUserByProperty();
	
	public int insertUser(User user);
}
