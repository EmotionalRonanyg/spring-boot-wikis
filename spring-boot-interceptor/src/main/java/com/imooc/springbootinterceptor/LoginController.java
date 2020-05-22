package com.imooc.springbootinterceptor;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 登录控制器
 */
@RestController
public class LoginController {
	/**
	 * 登录方法
	 */
	@RequestMapping("/login")
	public boolean login(HttpServletRequest request, String username, String password) {
		if ("imooc".equals(username) && "123".equals(password)) {
			// 登录成功，则添加Session并存储登录用户名
			request.getSession().setAttribute("LOGIN_NAME", username);
			return true;
		}
		return false;
	}

	/**
	 * 获取登录人员信息
	 */
	@RequestMapping("/info")
	public String info(HttpServletRequest request) {
		return "您就是传说中的：" + request.getSession().getAttribute("LOGIN_NAME");
	}
}
