package com.imooc.springbootaop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imooc.springbootaop.dao.GoodsDao;

/**
 * 商品服务类
 */
@Service
public class GoodsService {
	@Autowired
	private GoodsDao goodsDao;

	/**
	 * 获取商品信息列表
	 */
	public List getList() {
		return goodsDao.getList();
	}
}
