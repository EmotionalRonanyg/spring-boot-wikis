package com.imooc.springbootmultidb.mapper2;

/**
 * ERP订单数据类
 */
public class ErpOrderDo {
	/**
	 * 订单id
	 */
	private Long id;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getOutId() {
		return outId;
	}
	public void setOutId(Long outId) {
		this.outId = outId;
	}
	public Long getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	/**
	 * 商城系统订单id
	 */
	private Long outId;
	/**
	 * 商品id
	 */
	private Long goodsId;
	/**
	 * 购买数量
	 */
	private Long count;
	// 省略 get set
}
