package com.imooc.springbootrestful;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

/**
 * 商品服务
 */
@Service // 注册为服务类
public class GoodsService {
	/**
	 * 获取商品列表
	 */
	public List<GoodsDo> getGoodsList() {
		List<GoodsDo> goodsList = new ArrayList<GoodsDo>();
		GoodsDo goods = new GoodsDo();
		goods.setId(1L);
		goods.setName("苹果");
		goods.setPic("apple.jpg");
		goods.setPrice("3.5");
		goodsList.add(goods);
		return goodsList;
	}
	/**
	 * 按id获取商品信息，模拟返回对应商品信息
	 */
	public GoodsDo getGoodsById(Long id) {
		GoodsDo goods = new GoodsDo();
		goods.setId(1L);
		goods.setName("苹果");
		goods.setPic("apple.jpg");
		goods.setPrice("3.5");
		return goods;
	}
	/**
	 * 新增商品，模拟返回数据库影响行数
	 */
	public int addGoods(GoodsDo goods) {
		return 1;
	}
	/**
	 * 根据商品id更新商品信息，模拟返回数据库影响行数
	 */
	public int editGoods(GoodsDo goods) {
		return 1;
	}
	/**
	 * 根据商品id删除对应商品，模拟返回数据库影响行数
	 */
	public int removeGoods(Long id) {
		return 1;
	}
}
