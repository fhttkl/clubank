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
	
	//�Ѷ������л�
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
	
	//�Ѷ������л�
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
	 * �ж�keyֵ�Ƿ����
	 */
	public Boolean exist(String key) {
		// TODO Auto-generated method stub
		Jedis jedis=jedisPool.getResource();
		Boolean b=jedis.exists(key);
		jedis.close();
		return b;
	}
	
	/**
	 * ����keyɾ������
	 */
	public Long del(String key) {
		// TODO Auto-generated method stub
		Jedis jedis=jedisPool.getResource();
		Long result=jedis.del(keyConvertBytes(key));
		jedis.close();
		return result;
	}
	
	/**
	 * �����ַ�������
	 */
	public String setString(String key, String value) {
		// TODO Auto-generated method stub
		Jedis jedis=jedisPool.getResource();
		String result=jedis.set(key, value);
		jedis.close();
		return result;
	}
	
	/**
	 * ����ĳ��key����watchʱ����������Ŀͻ��˶�key�����˸��������������ȡ������������ǹܵ�������
	 */
	public String watch(String key) {
		// TODO Auto-generated method stub
		Jedis jedis=jedisPool.getResource();
		String result= jedis.watch(key);
		jedis.close();
		return result;
	}
	
	/**
	 * ��ȡjedis����
	 */
	public Jedis getJedis() {
		return jedisPool.getResource();
	}
	
	/**
	 * ����key��ѯ��value����value����
	 */
	public Long instr(String key) {
		// TODO Auto-generated method stub
		Jedis jedis=jedisPool.getResource();
		Long result=jedis.incr(key);
		jedis.close();
		return result;
	}
	
	/**
	 * ����key��ȡvalue
	 */
	public String getString(String key) {
		// TODO Auto-generated method stub
		Jedis jedis=jedisPool.getResource();
		String value=jedis.get(key);
		jedis.close();
		return value;
	}
}
