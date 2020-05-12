package com.imooc.springbootexceptionrestcontroller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Rest商品控制器
 */
@RestController
public class RestGoodsController {
	/**
	 * 正常方法
	 */
	@RequestMapping("/goods")
	public ResultBo goods() {
		return new ResultBo<>(new ArrayList());// 正常情况下应该返回商品列表
	}

	/**
	 * 抛出密码错误异常的方法
	 */
	@RequestMapping("/checkPassword")
	public ResultBo checkPassword() throws PasswordException {
		if (true) {
			throw new PasswordException();// 模拟抛出异常，便于测试
		}
		return new ResultBo<>(true);// 正常情况下应该返回检查密码的结果true或false
	}

	/**
	 * 抛出验证码错误异常的方法
	 */
	@RequestMapping("/checkVerification")
	public ResultBo checkVerification() throws VerificationCodeException {
		if (true) {
			throw new VerificationCodeException();// 模拟抛出异常，便于测试
		}
		return new ResultBo<>(true);// 正常情况下应该返回检查密码的结果true或false
	}

	/**
	 * 抛出未自定义的异常
	 */
	@RequestMapping("/other")
	public ResultBo other() throws Exception {
		int a = 1 / 0;// 模拟异常
		return new ResultBo<>(true);// 正常情况下应该返回检查密码的结果true或false
	}
}
