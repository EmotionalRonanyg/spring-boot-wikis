package com.imooc.springboottransaction;

/**
 * 订单类
 */
public class MyorderDo {
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
	 * 商品id
	 */
	private Long goodsId;
	/**
	 * 购买数量
	 */
	private Long count;
	// 省略 get set
}
