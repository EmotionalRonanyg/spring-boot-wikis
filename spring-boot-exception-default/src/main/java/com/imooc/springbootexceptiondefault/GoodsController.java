package com.imooc.springbootexceptiondefault;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 商品控制器
 */
@Controller
public class GoodsController {
	/**
	 * 正常方法
	 */
	@RequestMapping("/goods")
	public String goods() {
		return "goods";// 跳转到resource/template/goods.html页面
	}

	/**
	 * 抛出密码错误异常的方法
	 */
	@RequestMapping("/checkPassword")
	public String checkPassword() throws PasswordException {
		if (true) {
			throw new PasswordException();// 模拟抛出异常，便于测试
		}
		return "goods";
	}

	/**
	 * 抛出验证码错误异常的方法
	 */
	@RequestMapping("/checkVerification")
	public String checkVerification() throws VerificationCodeException {
		if (true) {
			throw new VerificationCodeException();// 模拟抛出异常，便于测试
		}
		return "goods";
	}

	/**
	 * 抛出未自定义的异常
	 */
	@RequestMapping("/other")
	public String other() throws Exception {
		int a = 1 / 0;// 模拟异常
		return "goods";
	}
}
