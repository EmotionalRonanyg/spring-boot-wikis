package com.imooc.springbootjpa;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JpaEditTest {
	@Autowired
	private IGoodsDao goodsDao;

	/**
	 * 测试新增
	 */
	@Test
	public void testEdit() {
		GoodsDo goods = new GoodsDo();
		goods.setId(1L);
		goods.setName("梨张");
		goods.setPic("梨图片");
		goods.setPrice("100.0");
		GoodsDo result = goodsDao.save(goods);
		assertNotNull(result);
	}
}
