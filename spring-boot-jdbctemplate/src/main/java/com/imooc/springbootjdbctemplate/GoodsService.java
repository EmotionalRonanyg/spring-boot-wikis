package com.imooc.springbootjdbctemplate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 * 商品服务类
 */
@Service
public class GoodsService {
	@Autowired
	private GoodsDao goodsDao;



	/**
	 * 新增商品
	 */
	public void add(GoodsDo goods) {
		goodsDao.insert(goods);
	}

	/**
	 * 删除商品
	 */
	public void remove(Long id) {
		goodsDao.delete(id);
	}

	/**
	 * 编辑商品信息
	 */
	public void edit(GoodsDo goods) {
		goodsDao.update(goods);
	}

	/**
	 * 按id获取商品信息
	 */
	public GoodsDo getById(Long id) {
		return goodsDao.getById(id);
	}

	/**
	 * 获取商品信息列表
	 */
	public List<GoodsDo> getList() {
		return goodsDao.getList();
	}
}
