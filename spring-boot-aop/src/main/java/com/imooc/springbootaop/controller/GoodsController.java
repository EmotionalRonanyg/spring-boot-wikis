package com.imooc.springbootaop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.imooc.springbootaop.ResultBo;
import com.imooc.springbootaop.service.GoodsService;

/**
 * 商品控制器类
 */
@RestController
public class GoodsController {
	@Autowired
	private GoodsService goodsService;

	/**
	 * 获取商品列表
	 */
	@GetMapping("/goods")
	public ResultBo getList() {
		return new ResultBo(goodsService.getList());
	}

	/**
	 * 模拟抛出异常的方法
	 */
	@GetMapping("/test")
	public ResultBo test() {
		int a = 1 / 0;
		return new ResultBo(goodsService.getList());
	}
}
