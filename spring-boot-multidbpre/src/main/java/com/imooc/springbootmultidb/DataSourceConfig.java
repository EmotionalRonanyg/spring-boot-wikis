package com.imooc.springbootmultidb;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // 标注为配置类
public class DataSourceConfig {
	/**
	 * 数据源1
	 */
	@Bean // 返回值注册为组件
	@ConfigurationProperties("spring.datasource.db1") // 使用spring.datasource.db1作为前缀的配置
	public DataSource db1() {
		return DataSourceBuilder.create().build();
	}

	/**
	 * 数据源2
	 */
	@Bean // 返回值注册为组件
	@ConfigurationProperties("spring.datasource.db2") // 使用spring.datasource.db2作为前缀的配置
	public DataSource db2() {
		return DataSourceBuilder.create().build();
	}
}