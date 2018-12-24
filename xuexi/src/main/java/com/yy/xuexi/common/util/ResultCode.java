package com.yy.xuexi.common.util;

public enum ResultCode {

	
	//³É¹¦
	SUCC(1),
	//Ê§°Ü
	FAIL(-1);
	
	private int value;
	
	private ResultCode(int value){
		this.value=value;
	}
	
	public int getValue() {
		return this.value;
	}
}
