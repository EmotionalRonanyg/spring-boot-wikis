package com.imooc.springbootlog;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LogTest {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Test
	void testPrintLog() {
		logger.trace("trace log");
		logger.debug("debug log");
		logger.info("info log");
		logger.warn("warn log");
		logger.error("error log");
	}
}
