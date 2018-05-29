package com.project.util;

public class MessageBean {

	private String sign;
	private Object data;

	public MessageBean() {
		super();
	}

	public MessageBean(String sign, Object data) {
		super();
		this.sign = sign;
		this.data = data;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
