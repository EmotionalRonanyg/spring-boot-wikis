package com.imooc.springbootexceptiondefault;

/**
 * 自定义异常
 */
public class BaseException extends Exception {
	/**
	 * 错误码
	 */
	private int code;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public BaseException(int code, String msg) {
		super(msg);
		this.code = code;
	}
}
