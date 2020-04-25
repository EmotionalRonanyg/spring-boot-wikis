package com.imooc.springbootthymeleaf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 商品控制器
 */
@Controller
public class GoodsController {
	@Autowired
	private GoodsService goodsService;// 自动装配

	@RequestMapping("/goods") // 请求路径
	public String goods(Model model) {
		model.addAttribute("goodsList", goodsService.getGoodsList());// 交给模板引擎处理的数据
		return "goods.html";// 跳转到goods.html页面
	}
}