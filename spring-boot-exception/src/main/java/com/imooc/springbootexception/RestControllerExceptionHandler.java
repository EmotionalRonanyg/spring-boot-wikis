package com.imooc.springbootexception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Rest控制器异常处理类
 */
@RestControllerAdvice // 全局异常处理
public class RestControllerExceptionHandler {
	/**
	 * 处理BaseException类(及其子类)的异常时
	 */
	@ExceptionHandler(BaseException.class)
	public ResultBo customBaseException(BaseException e) {
		return new ResultBo(e);
	}

	/**
	 * 处理Exception的异常
	 */
	@ExceptionHandler(Exception.class)
	public ResultBo customException(Exception e) {
		return new ResultBo(e);
	}
}
