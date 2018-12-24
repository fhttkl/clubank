package com.yy.xuexi.manage.base.service.impl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

import com.yy.xuexi.common.redis.JedisClientPool;
import com.yy.xuexi.common.redis.RedisKeyCode;
import com.yy.xuexi.manage.base.service.BaseCodeRuleService;

@Service("baseCodeRuleService")
public class BaseCodeRuleServiceImpl implements BaseCodeRuleService{

	@Autowired
	private JedisClientPool jedisClientPool;
	
	public String getCode(String itemCode) {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
		//今天的key
		String today=RedisKeyCode.CARD_NO+sdf.format(new Date());
		String result=RedisKeyCode.CARD_NO.getValue()+new SimpleDateFormat("yyyyMMdd").format(new Date());
		Calendar c=Calendar.getInstance();
		c.add(Calendar.DAY_OF_MONTH, -1);
		//昨天的key
		String yesterday=RedisKeyCode.CARD_NO+sdf.format(c.getTime());
		//如果今天第一次生产则需要删除昨天的编号，如果今天不是第一次则只需要在今天的当前需要上加1
		if(!jedisClientPool.exist(today)){
			//不存在先删除昨天的在给今天添加
			jedisClientPool.del(yesterday);
			jedisClientPool.setString(today, "0");
		}
			//存在
			//当对某个key进行watch时，如果其他的客户端对key进行了更改事务可以做到取消事务操作但是管道不可以
			jedisClientPool.watch(today);
			Jedis jedis=jedisClientPool.getJedis();
			//开启事务
			Transaction transaction=jedis.multi();
			//自增
			jedisClientPool.instr(today);
			List<Object> objects=transaction.exec();
			//获取自增后的key
			String todayValue=jedisClientPool.getString(today);
			//if(objects!=null&&objects.size()>0&&today!=null){
				if(todayValue.length()<4){
					String code=String.format("%4s", todayValue);
					code=code.replaceAll(" ", "0");
					result+=code;
				}
			//}
			jedis.close();
		return result;
	}

	
}
