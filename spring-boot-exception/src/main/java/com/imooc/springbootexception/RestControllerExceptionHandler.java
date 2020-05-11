package com.imooc.springbootexception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Rest控制器异常处理类
 */
@RestControllerAdvice(annotations = RestController.class) // 全局异常处理
public class RestControllerExceptionHandler {
	/**
	 * 处理BaseException类(及其子类)的异常时
	 */
	@ExceptionHandler({ BaseException.class })
	public ResultBo customBaseException(BaseException e) {
		return new ResultBo(e);
	}

}
