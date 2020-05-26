package com.imooc.springbootcache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * 商品服务类
 */
@Service
@CacheConfig(cacheNames = "GoodsCache")
public class GoodsService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 按id获取商品信息
	 */
	@Cacheable
	public GoodsDo getById(Long id) {
		logger.info("getById({})", id);
		GoodsDo goods = new GoodsDo();
		goods.setId(id);
		goods.setName("goods-" + id);
		return goods;
	}

	/**
	 * 删除商品
	 */
	@CacheEvict(key = "#id")
	public void remove(Long id) {
		logger.info("remove({})", id);
	}

	/**
	 * 编辑商品信息
	 */
	@CachePut(key = "#goods.id")
	public GoodsDo edit(GoodsDo goods) {
		logger.info("edit id:{}", goods.getId());
		return goods;
	}
}
