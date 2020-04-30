package com.imooc.springboottransaction;

import org.springframework.stereotype.Repository;

/**
 * 订单数据库访问接口
 */
@Repository // 标注数据访问组件
public interface OrderDao {
	/**
	 * 新增订单
	 */
	public int insert(OrderDo order);
}