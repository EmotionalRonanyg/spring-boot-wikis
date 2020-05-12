package com.imooc.springbootexception;

/**
 * 验证码错误异常
 */
public class VerificationCodeException extends BaseException {
	public VerificationCodeException() {
		super(10002, "验证码错误");
	}
}
