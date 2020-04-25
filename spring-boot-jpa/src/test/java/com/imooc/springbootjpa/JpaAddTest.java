package com.imooc.springbootjpa;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JpaAddTest {
	@Autowired
	private IGoodsDao goodsDao;

	/**
	 * 测试新增
	 */
	@Test
	public void testAdd() {
		GoodsDo goods = new GoodsDo();
		goods.setName("梨张");
		goods.setPic("梨图片");
		goods.setPrice("2.0");
		GoodsDo result = goodsDao.save(goods);
		System.out.println("新增商品id：" + result.getId());
		assertNotNull(result);
	}
}
