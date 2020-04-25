package com.imooc.springbootfreemaker;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

/**
 * 商品服务
 */
@Service // 注册为服务类
public class GoodsService {
	public List<GoodsDo> getGoodsList() {
		List<GoodsDo> list = new ArrayList<GoodsDo>();
		GoodsDo goods = new GoodsDo();
		goods.setName("苹果");
		goods.setPic("apple.jpg");
		goods.setPrice("3.5");
		list.add(goods);
		return list;
	}
}
