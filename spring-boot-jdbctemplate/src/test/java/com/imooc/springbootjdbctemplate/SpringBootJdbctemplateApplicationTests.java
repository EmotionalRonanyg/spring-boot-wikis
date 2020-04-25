package com.imooc.springbootjdbctemplate;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest // 通过该注解，开启测试类功能，当测试方法启动时，启动了Spring容器
class SpringBootJdbctemplateApplicationTests {

	@Autowired
	private DataSource dataSource;// 自动注入数据源

	@Autowired
	private 
	
	/**
	 * 打印数据源信息
	 */
	@Test // 测试方法
	void printDataSource() {
		System.out.println(dataSource);
	}

	/**
	 * 批量插入测试
	 */
	@Test
	void insertBatch() {
		
	}
}
