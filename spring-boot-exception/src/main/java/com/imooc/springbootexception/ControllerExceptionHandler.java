package com.imooc.springbootexception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * 控制器异常处理类
 */
@ControllerAdvice // 全局异常处理
public class ControllerExceptionHandler {
	@ExceptionHandler(BaseException.class) // 当发生BaseException类(及其子类)的异常时，进入该方法
	public ModelAndView customException(BaseException e) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("code", e.getCode());
		mv.addObject("message", e.getMessage());
		mv.setViewName("myerror");// 跳转到resource/template/myerror.html页面
		return mv;
	}
}
