package com.imooc.springboottransaction;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 订单测试
 */
@SpringBootTest
class OrderTest {

	@Autowired
	private OrderService orderService;

	/**
	 * 创建订单测试
	 */
	@Test
	void testCreateOrder() throws Exception {
		// 购买id为1的商品1份
		int affectRows = orderService.startCreateOrder(1L, 100L);
		assertEquals(1, affectRows);
	}
}