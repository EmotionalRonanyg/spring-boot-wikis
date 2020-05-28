package com.imooc.springbootcache;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.CacheManager;

@SpringBootTest
class SpringBootCacheApplicationTests {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private CacheManager cacheManager;

	@Autowired
	private GoodsService goodsService;

	// 显示当前使用的缓存管理器类型
	@Test
	void showCacheManager() {
		// 输出：org.springframework.cache.concurrent.ConcurrentMapCacheManager
		logger.info(cacheManager.getClass().toString());
	}

	// 缓存测试
	@Test
	void cacheTest() {
		// 第一次执行，没有缓存，执行方法体
		goodsService.getById(1L);
		// 再次执行，直接取出缓存，不执行方法体
		goodsService.getById(1L);
		// 移除缓存
		goodsService.remove(1L);
		// 再次执行，已经没有对应缓存，所以执行方法体
		GoodsDo oldGoods = goodsService.getById(1L);
		// 打印缓存内容
		logger.info("old goods id:{} name:{}", oldGoods.getId(), oldGoods.getName());
		// 更新缓存
		GoodsDo temp = new GoodsDo();
		temp.setId(1L);
		temp.setName("新的商品");
		goodsService.edit(temp);
		// 查询并打印已更新的缓存内容
		GoodsDo newGoods = goodsService.getById(1L);
		logger.info("new goods id:{} name:{}", newGoods.getId(), newGoods.getName());
	}
}
