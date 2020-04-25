package com.imooc.springboothikari;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest // 通过该注解，开启测试类功能，当测试方法启动时，启动了Spring容器
class SpringBootHikariApplicationTests {
	@Autowired
	private DataSource dataSource;// 自动注入数据源
	@Autowired
	private GoodsDao goodsDao;

	/**
	 * 打印数据源信息
	 */
	@Test // 测试方法
	void printDataSource() {
		System.out.println(dataSource.getClass().getName());
	}

	/**
	 * 批量插入测试
	 */
	@Test
	void insertBatch() {
		// 开始时间
		long startTime = System.currentTimeMillis();
		// 执行1000次插入
		GoodsDo goods = new GoodsDo();
		goods.setName("测试");
		goods.setPic("测试图片");
		goods.setPrice("1.0");
		for (int i = 0; i < 1000; i++) {
			goodsDao.insert(goods);
		}
		// 输出操作时间
		System.out.println("use time:" + (System.currentTimeMillis() - startTime)+"ms");
	}
}
