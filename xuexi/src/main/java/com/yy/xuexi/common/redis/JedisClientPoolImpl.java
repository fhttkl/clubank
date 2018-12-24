package com.yy.xuexi.common.redis;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class JedisClientPoolImpl implements JedisClientPool{

	
	private JedisPool jedisPool;

	public JedisPool getJedisPool() {
		return jedisPool;
	}
	public void setJedisPool(JedisPool jedisPool) {
		this.jedisPool = jedisPool;
	}
	
	public String set(String key, Object value) {
		Jedis jedis=jedisPool.getResource();
		return jedis.set(keyConvertBytes(key), valueConvertBytes(value));
	}

	
	public byte[] keyConvertBytes(String key){
		return key.getBytes();
	}
	
	//把对象序列化
	public byte[] valueConvertBytes(Object value){
		ByteArrayOutputStream baos=new ByteArrayOutputStream();
		ObjectOutputStream oos=null;
		try {
			oos=new ObjectOutputStream(baos);
			oos.writeObject(value);
			byte[] bytes=baos.toByteArray();
			baos.flush();
			return bytes;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				baos.close();
				oos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
	
	//把对象反序列化
	public Object bytesConvertObject(byte[] bytes){
		ByteArrayInputStream bais=new ByteArrayInputStream(bytes);
		Object object=null;
		ObjectInputStream ois=null;
		try {
			ois=new ObjectInputStream(bais);
			object = ois.readObject();
			return object;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				ois.close();
				bais.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
	/**
	 * 判断key值是否存在
	 */
	public Boolean exist(String key) {
		// TODO Auto-generated method stub
		Jedis jedis=jedisPool.getResource();
		Boolean b=jedis.exists(key);
		jedis.close();
		return b;
	}
	
	/**
	 * 根据key删除数据
	 */
	public Long del(String key) {
		// TODO Auto-generated method stub
		Jedis jedis=jedisPool.getResource();
		Long result=jedis.del(keyConvertBytes(key));
		jedis.close();
		return result;
	}
	
	/**
	 * 设置字符串类型
	 */
	public String setString(String key, String value) {
		// TODO Auto-generated method stub
		Jedis jedis=jedisPool.getResource();
		String result=jedis.set(key, value);
		jedis.close();
		return result;
	}
	
	/**
	 * 当对某个key进行watch时，如果其他的客户端对key进行了更改事务可以做到取消事务操作但是管道不可以
	 */
	public String watch(String key) {
		// TODO Auto-generated method stub
		Jedis jedis=jedisPool.getResource();
		String result= jedis.watch(key);
		jedis.close();
		return result;
	}
	
	/**
	 * 获取jedis对象
	 */
	public Jedis getJedis() {
		return jedisPool.getResource();
	}
	
	/**
	 * 根据key查询到value并让value自增
	 */
	public Long instr(String key) {
		// TODO Auto-generated method stub
		Jedis jedis=jedisPool.getResource();
		Long result=jedis.incr(key);
		jedis.close();
		return result;
	}
	
	/**
	 * 根据key获取value
	 */
	public String getString(String key) {
		// TODO Auto-generated method stub
		Jedis jedis=jedisPool.getResource();
		String value=jedis.get(key);
		jedis.close();
		return value;
	}
}
