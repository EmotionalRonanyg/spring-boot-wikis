package com.imooc.springboottransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 订单服务类
 */
@Service // 注册为服务类
public class OrderService {
	@Autowired
	private GoodsDao goodsDao;
	@Autowired
	private OrderDao orderDao;

	@Transactional // 开启事务
	public int startCreateOrder(Long goodsId, Long count) throws Exception {
		return this.createOrder(goodsId, count);
	}

	/**
	 * 下单
	 * 
	 * @param goodsId 购买商品id
	 * @param count   购买商品数量
	 * @return 生成订单数
	 */
	@Transactional(rollbackFor = Exception.class) // 抛出异常即回滚
	public int createOrder(Long goodsId, Long count) throws Exception {
		// 锁定商品库存
		GoodsDo goods = goodsDao.selectForUpdate(goodsId);
		// 扣减库存
		Long newNum = goods.getNum() - count;
		goods.setNum(newNum);
		goodsDao.update(goods);
		if (count > goods.getNum()) {
			// 非受检查异常抛出时，会回滚
			throw new Exception();
		}
		// 生成订单
		OrderDo order = new OrderDo();
		order.setGoodsId(goodsId);
		order.setCount(count);
		int affectRows = orderDao.insert(order);
		return affectRows;
	}
}
