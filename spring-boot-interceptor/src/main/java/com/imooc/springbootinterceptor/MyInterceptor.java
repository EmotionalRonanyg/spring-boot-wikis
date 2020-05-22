package com.imooc.springbootinterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

/**
 * 自定义拦截器类
 */
public class MyInterceptor implements HandlerInterceptor {// 实现HandlerInterceptor接口
	/**
	 * 访问控制器方法前执行
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if (request.getRequestURI().contains("/login") == true) {// 登录方法直接放行
			return true;
		} else {// 其他方法需要先检验是否存在Session
			if (request.getSession().getAttribute("LOGIN_NAME") == null) {// 未登录的不允许访问
				response.getWriter().write("Please Login");
				return false;
			} else {
				return true;
			}
		}
	}
}
