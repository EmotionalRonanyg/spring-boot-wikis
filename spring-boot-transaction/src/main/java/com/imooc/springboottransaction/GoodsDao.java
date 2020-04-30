package com.imooc.springboottransaction;

import org.springframework.stereotype.Repository;

/**
 * 商品数据库访问接口
 */
@Repository // 标注数据访问组件
public interface GoodsDao {
	/**
	 * 查询商品信息(根据id查询单个商品信息)
	 */
	public GoodsDo selectForUpdate(Long id);

	/**
	 * 修改商品信息(根据id修改其他属性值)
	 */
	public int update(GoodsDo Goods);
}