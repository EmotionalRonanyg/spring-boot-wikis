package com.imooc.springbootmultidb.mapper1;

import org.springframework.stereotype.Repository;

/**
 * 数据访问接口
 */
@Repository
public interface OrderDao {
	public int insert(OrderDo order);
}
