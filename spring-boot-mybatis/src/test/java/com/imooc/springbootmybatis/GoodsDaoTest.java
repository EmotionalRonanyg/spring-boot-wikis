package com.imooc.springbootmybatis;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * GoodsDao测试类
 */
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING) // 按方法名称顺序测试
class GoodsDaoTest {

	@Autowired
	private GoodsDao goodsDao;

	/**
	 * 新增一个商品
	 */
	@Test
	void test_01() {
		GoodsDo goods = new GoodsDo();
		goods.setName("手机");
		goods.setPic("phone.jpg");
		goods.setPrice("2000");
		int count = goodsDao.insert(goods);
		assertEquals(1, count);// count值为1则测试通过
	}

	/**
	 * 更新商品信息
	 */
	@Test
	void test_02() {
		GoodsDo goods = new GoodsDo();
		goods.setId(1L);
		goods.setName("手机");
		goods.setPic("phone.jpg");
		goods.setPrice("3000");
		int count = goodsDao.update(goods);
		assertEquals(1, count);// count值为1则测试通过
	}

	/**
	 * 获取商品信息
	 */
	@Test
	void test_03() {
		GoodsDo goods = goodsDao.selectOne(1L);
		assertNotNull(goods);// goods不为null则测试通过
	}

	/**
	 * 删除商品
	 */
	@Test
	void test_04() {
		int count = goodsDao.delete(1L);
		assertEquals(1, count);// count值为1则测试通过
	}

	/**
	 * 获取商品信息列表
	 */
	@Test
	void test_05() {
		List<GoodsDo> goodsList = goodsDao.selectAll();
		assertEquals(0, goodsList.size());// goodsList.size()值为0则测试通过
	}
}
