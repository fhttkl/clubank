package com.yy.xuexi.common.util;

public enum ResultCode {

	
	//�ɹ�
	SUCC(1),
	//ʧ��
	FAIL(-1);
	
	private int value;
	
	private ResultCode(int value){
		this.value=value;
	}
	
	public int getValue() {
		return this.value;
	}
}
