package com.yy.xuexi.common.redis;

public enum RedisKeyCode {

	/**
	 * Card_No
	 */
	CARD_NO("CardNo");
	
	private String value;
	
	private RedisKeyCode(String value){
		this.value=value;
	}
	
	public String getValue(){
		return this.value;
	}
}
