package com.imooc.springbootexception;

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
		if (true) {// 必然抛出异常，便于测试
			throw new PasswordException();
		}
		return "goods";
	}

	/**
	 * 抛出密码错误异常的方法
	 */
	@RequestMapping("/checkVassword")
	public String checkVassword() throws VerificationCodeException {
		if (true) {// 必然抛出异常，便于测试
			throw new VerificationCodeException();
		}
		return "goods";
	}
}
