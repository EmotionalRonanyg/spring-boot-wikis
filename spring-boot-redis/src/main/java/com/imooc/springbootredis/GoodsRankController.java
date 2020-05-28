package com.imooc.springbootredis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GoodsRankController {
	@Autowired
	private GoodsRankService goodsRankService;
	
	@GetMapping("getRankList")
	public List getRankList() throws Exception {
		return goodsRankService.getRandkList();
	}
}
