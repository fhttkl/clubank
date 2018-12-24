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
		//�����key
		String today=RedisKeyCode.CARD_NO+sdf.format(new Date());
		String result=RedisKeyCode.CARD_NO.getValue()+new SimpleDateFormat("yyyyMMdd").format(new Date());
		Calendar c=Calendar.getInstance();
		c.add(Calendar.DAY_OF_MONTH, -1);
		//�����key
		String yesterday=RedisKeyCode.CARD_NO+sdf.format(c.getTime());
		//��������һ����������Ҫɾ������ı�ţ�������첻�ǵ�һ����ֻ��Ҫ�ڽ���ĵ�ǰ��Ҫ�ϼ�1
		if(!jedisClientPool.exist(today)){
			//��������ɾ��������ڸ��������
			jedisClientPool.del(yesterday);
			jedisClientPool.setString(today, "0");
		}
			//����
			//����ĳ��key����watchʱ����������Ŀͻ��˶�key�����˸��������������ȡ������������ǹܵ�������
			jedisClientPool.watch(today);
			Jedis jedis=jedisClientPool.getJedis();
			//��������
			Transaction transaction=jedis.multi();
			//����
			jedisClientPool.instr(today);
			List<Object> objects=transaction.exec();
			//��ȡ�������key
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
