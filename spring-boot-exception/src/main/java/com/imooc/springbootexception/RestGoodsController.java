package com.imooc.springbootexception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Rest 商品控制器
 */
@RestController
public class RestGoodsController {
	/**
	 * 正常方法
	 */
	@RequestMapping("/rest_goods")
	public ResultBo rest_goods() {
		return new ResultBo<>(new ArrayList());// 正常情况下应该返回商品列表
	}

	/**
	 * 抛出密码错误异常的方法
	 */
	@RequestMapping("/rest_checkPassword")
	public ResultBo rest_checkPassword() throws BaseException {
		if (true) {
			throw new PasswordException();
		}
		return new ResultBo<>(true);// 正常情况下应该返回检查密码的结果true或false
	}

	/**
	 * 抛出密码错误异常的方法
	 */
	@RequestMapping("/rest_checkVassword")
	public ResultBo rest_checkVassword() throws BaseException {
		if (true) {// 必然抛出异常，便于测试
			throw new VerificationCodeException();
		}
		return new ResultBo<>(true);// 正常情况下应该返回检查验证码的结果true或false
	}

	/**
	 * 抛出不属于自定义异常类的异常
	 */
	@RequestMapping("/rest_throwOtherException")
	public ResultBo rest_throwOtherException() throws Exception {
		int a = 1 / 0;// 模拟抛出异常
		return new ResultBo<>(true);
	}
}
