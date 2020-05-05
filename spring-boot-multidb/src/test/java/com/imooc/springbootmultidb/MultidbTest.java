package com.imooc.springbootmultidb;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.imooc.springbootmultidb.mapper1.OrderDao;
import com.imooc.springbootmultidb.mapper1.OrderDo;
import com.imooc.springbootmultidb.mapper2.ErpOrderDao;
import com.imooc.springbootmultidb.mapper2.ErpOrderDo;

/**
 * 多数据源测试
 */
@SpringBootTest
class MultidbTest {
	@Autowired
	private OrderDao orderDao;// 对应数据源1
	@Autowired
	private ErpOrderDao erpOrderDao;// 对应数据源2

	/**
	 * 插入测试
	 */
	@Test
	void testInsert() {
		// 数据源1插入数据
		OrderDo order = new OrderDo();
		order.setCount(1L);
		order.setGoodsId(1L);
		int affectRows1 = orderDao.insert(order);
		// 数据源2插入数据
		ErpOrderDo erpOrder = new ErpOrderDo();
		erpOrder.setCount(order.getCount());
		erpOrder.setGoodsId(order.getGoodsId());
		erpOrder.setOutId(order.getId());
		int affectRows2 = erpOrderDao.insert(erpOrder);
		assertEquals(1, affectRows1);
		assertEquals(1, affectRows2);
	}
}
