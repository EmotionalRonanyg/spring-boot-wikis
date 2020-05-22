package com.imooc.springbootsecurity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 商品控制器类
 */
@RestController
public class GoodsController {

	/**
	 * 添加商品
	 */
	@GetMapping("/addGoods")
	public String addGoods() {
		return "success";
	}

	/**
	 * 删除商品
	 */
	@GetMapping("/removeGoods")
	public String removeGoods() {
		return "success";
	}

	/**
	 * 修改商品
	 */
	@GetMapping("/editGoods")
	public String editGoods() {
		return "success";
	}

	/**
	 * 查看商品
	 */
	@GetMapping("/viewGoods")
	public String viewGoods() {
		return "success";
	}

}
