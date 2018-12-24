package com.yy.xuexi.common.redis;

import redis.clients.jedis.Jedis;

public interface JedisClientPool {

	/**
	 * ����key��value
	 */
	public String set(String key,Object value);
	/**
	 * �ж�key�Ƿ����
	 * @param key
	 * @return
	 */
	public Boolean exist(String key);
	/**
	 * ����keyɾ������
	 * @param today
	 * @return
	 */
	public Long del(String key);
	
	/**
	 * �����ַ�����������
	 * @param key
	 * @param value
	 * @return
	 */
	public String setString(String key,String value);
	/**
	 * ����ĳ��key����watchʱ����������Ŀͻ��˶�key�����˸��������������ȡ������������ǹܵ�������
	 * @param today
	 * @return
	 */
	public String watch(String key);
	/**
	 * ��ȡjedis
	 * @return
	 */
	public Jedis getJedis();
	/**
	 * ����key�ҵ�value������
	 * @param today
	 */
	public Long instr(String key);
	
	/**
	 * ����key��ȡvalue
	 * @param today
	 * @return
	 */
	public String getString(String key);
}
