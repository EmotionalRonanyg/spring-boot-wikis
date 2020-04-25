package com.imooc.springbootjpa;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 商品服务类
 */
@Service
public class GoodsService {
	@Autowired
	private IGoodsDao goodsDao;

	/**
	 * 新增商品
	 */
	public void add(GoodsDo goods) {
		goodsDao.save(goods);
	}

	/**
	 * 删除商品
	 */
	public void remove(Long id) {
		goodsDao.deleteById(id);
	}

	/**
	 * 编辑商品信息
	 */
	public void edit(GoodsDo goods) {
		goodsDao.save(goods);
	}

	/**
	 * 按id获取商品信息
	 */
	public Optional<GoodsDo> getById(Long id) {
		return goodsDao.findById(id);
	}

	/**
	 * 获取商品信息列表
	 */
	public Iterable<GoodsDo> getList() {
		return goodsDao.findAll();
	}
}
