package com.imooc.springbootcors;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * 商品控制器类
 */
@RestController
public class GoodsController {
	@Autowired
	private GoodsService goodsService;

	@GetMapping("/goods")//遵循Restful规范的接口
	public List<GoodsDo> getList() {
		return goodsService.getGoodsList();
	}
}
