package com.imooc.springbootjpa;

import static org.junit.Assert.*;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JpaQueryTest {
	@Autowired
	private IGoodsDao goodsDao;

	/**
	 * 按id查询
	 */
	@Test
	public void testQueryById() {
		Optional<GoodsDo> goodsOptional = goodsDao.findById(1L);
		GoodsDo goods = goodsOptional.get();
		System.out.println(goods.getId() + "-" + goods.getName() + "-" + goods.getPic() + "-" + goods.getPrice());
	}

	/**
	 * 查询全部
	 */
	@Test
	public void testQueryAll() {
		Iterable<GoodsDo> goodsIt = goodsDao.findAll();
		for (GoodsDo goods : goodsIt) {
			System.out.println(goods.getId() + "-" + goods.getName() + "-" + goods.getPic() + "-" + goods.getPrice());
		}
	}
}
