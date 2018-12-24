package com.yy.xuexi.manage.user.service;

import com.yy.xuexi.common.util.CommonResult;
import com.yy.xuexi.manage.user.pojo.User;

public interface UserService {

	/**
	 * ���ݻ�Ա���ţ���Ա��������Ա�绰��ҳ��ѯ��Ա��Ϣ
	 * @param cardNo
	 * @param name
	 * @param tel
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	public CommonResult selectUsersByProperty(String cardNo,String name,String tel,Integer pageIndex,Integer pageSize);
	
	
	/**
	 * ���ݻ�Ա���ţ���Ա��������Ա�绰��ҳ��ѯ��Ա��Ϣ
	 * @param user
	 * @return
	 */
	public CommonResult register(User user);
	
}
