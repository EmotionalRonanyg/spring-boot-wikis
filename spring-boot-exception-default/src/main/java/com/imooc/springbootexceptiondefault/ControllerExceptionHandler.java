package com.imooc.springbootexceptiondefault;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * 控制器异常处理类
 */
@ControllerAdvice(annotations = Controller.class) // 全局异常处理
public class ControllerExceptionHandler {
	@ExceptionHandler({ BaseException.class }) // 当发生BaseException类(及其子类)的异常时，进入该方法
	public ModelAndView baseExceptionHandler(BaseException e) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("code", e.getCode());
		mv.addObject("message", e.getMessage());
		mv.setViewName("myerror");// 跳转到resource/template/myerror.html页面
		return mv;
	}

	@ExceptionHandler({ Exception.class }) // 当发生Exception类的异常时，进入该方法
	public ModelAndView exceptionHandler(Exception e) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("code", 99999);// 其他异常统一编码为99999
		mv.addObject("message", e.getMessage());
		mv.setViewName("myerror");// 跳转到resource/template/myerror.html页面
		return mv;
	}
}
