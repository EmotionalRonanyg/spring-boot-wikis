package com.imooc.springbootmultidb.mapper2;

import org.springframework.stereotype.Repository;

/**
 * 数据访问接口
 */
@Repository
public interface ErpOrderDao {
	public int insert(ErpOrderDo erpOrder);
}
