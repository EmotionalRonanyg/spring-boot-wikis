package com.imooc.springbootsecurity;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	/**
	 * 未登录时调用该方法
	 */
	@RequestMapping("/notLogin")
	public ResultBo notLogin() {
		return new ResultBo(new Exception("未登录"));
	}

	/**
	 * 查看商品
	 */
	@RequestMapping("/viewGoods")
	public ResultBo viewGoods() {
		return new ResultBo<>("viewGoods is ok");
	}

	/**
	 * 添加商品
	 */
	@RequestMapping("/addGoods")
	public ResultBo addGoods() {
		return new ResultBo<>("addGoods is ok");
	}
}
