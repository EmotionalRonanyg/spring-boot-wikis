package com.imooc.springbootredis;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBootRedisApplicationTests {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private VisitService visitService;

	@Test
	void test() {
		logger.info("访问次数：{}", visitService.getCurrentCount());
		ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
		for (int i = 0; i < 10000; i++) {
			cachedThreadPool.execute(new Runnable() {
				public void run() {
					visitService.addCount();
				}
			});
		}
	}
}
