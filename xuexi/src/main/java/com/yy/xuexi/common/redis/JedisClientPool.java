package com.yy.xuexi.common.redis;

import redis.clients.jedis.Jedis;

public interface JedisClientPool {

	/**
	 * 设置key和value
	 */
	public String set(String key,Object value);
	/**
	 * 判断key是否存在
	 * @param key
	 * @return
	 */
	public Boolean exist(String key);
	/**
	 * 根据key删除数据
	 * @param today
	 * @return
	 */
	public Long del(String key);
	
	/**
	 * 设置字符串类型数据
	 * @param key
	 * @param value
	 * @return
	 */
	public String setString(String key,String value);
	/**
	 * 当对某个key进行watch时，如果其他的客户端对key进行了更改事务可以做到取消事务操作但是管道不可以
	 * @param today
	 * @return
	 */
	public String watch(String key);
	/**
	 * 获取jedis
	 * @return
	 */
	public Jedis getJedis();
	/**
	 * 根据key找到value并自增
	 * @param today
	 */
	public Long instr(String key);
	
	/**
	 * 根据key获取value
	 * @param today
	 * @return
	 */
	public String getString(String key);
}
