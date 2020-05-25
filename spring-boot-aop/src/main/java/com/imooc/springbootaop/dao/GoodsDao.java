package com.imooc.springbootaop.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

/**
 * 商品数据库访问类
 */
@Repository // 标注数据访问类
public class GoodsDao {

	/**
	 * 查询商品列表
	 */
	public List getList() {
		return new ArrayList();
	}
}
