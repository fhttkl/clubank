package com.yy.xuexi.common.util;

public class CommonResult {

	private Integer apiStatus;//��Ӧҵ��״̬
	private String msg;//��Ӧ�ı�
	private Object data;//��Ӧ����
	
	
	
	
	public Integer getApiStatus() {
		return apiStatus;
	}
	public void setApiStatus(Integer apiStatus) {
		this.apiStatus = apiStatus;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public static CommonResult result(Integer apiStatus,String msg,Object data){
		return new CommonResult(apiStatus,msg,data);
	}
	public static CommonResult result(Integer apiStatus,String msg){
		return new CommonResult(apiStatus,msg);
	}

	public CommonResult(Integer apiStatus, String msg, Object data) {
		super();
		this.apiStatus = apiStatus;
		this.msg = msg;
		this.data = data;
	}


	public CommonResult(Integer apiStatus, String msg) {
		super();
		this.apiStatus = apiStatus;
		this.msg = msg;
	}


	public CommonResult() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
