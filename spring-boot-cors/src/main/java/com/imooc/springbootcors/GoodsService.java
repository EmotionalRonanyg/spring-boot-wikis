package com.imooc.springbootcors;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

/**
 * 商品服务类
 */
@Service // 注册为服务类
public class GoodsService {
	/**
	 * 获取商品列表
	 */
	public List<GoodsDo> getGoodsList() {
		List<GoodsDo> goodsList = new ArrayList<GoodsDo>();//模拟从数据库查询出的结果返回
		GoodsDo goods = new GoodsDo();
		goods.setId(1L);
		goods.setName("苹果");
		goods.setPic("apple.jpg");
		goods.setPrice("3.5");
		goodsList.add(goods);
		return goodsList;
	}
}
