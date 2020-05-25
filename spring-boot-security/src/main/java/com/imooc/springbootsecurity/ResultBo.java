package com.imooc.springbootsecurity;

/**
 * 后端接口返回的统一业务逻辑对象
 */
public class ResultBo<T> {

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	/**
	 * 错误码 0表示没有错误(异常) 其他数字代表具体错误码
	 */
	private int code;
	/**
	 * 后端返回消息
	 */
	private String msg;
	/**
	 * 后端返回的数据
	 */
	private T data;

	/**
	 * 无参数构造函数
	 */
	public ResultBo() {
		this.code = 0;
		this.msg = "操作成功";
	}

	/**
	 * 带数据data构造函数
	 */
	public ResultBo(T data) {
		this();
		this.data = data;
	}

	/**
	 * 存在异常的构造函数
	 */
	public ResultBo(Exception ex) {
		this.code = 99999;// 其他未定义异常
		this.msg = ex.getMessage();
	}

}