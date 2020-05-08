package com.imooc.springbootlog;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j // 添加日志输出注解
class LogTest {
	// 不再需要定义 logger
	// private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Test
	void testPrintLog() {
		// 直接使用log输出日志
		log.trace("trace log");
		log.debug("debug log");
		log.info("info log");
		log.warn("warn log");
		log.error("error log");
	}
}