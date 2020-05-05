package com.imooc.springbootmultidb;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

/**
 * 数据源1 MyBatis配置
 */
@Configuration
@MapperScan(value = "com.imooc.springbootmultidb.mapper1", sqlSessionFactoryRef = "sqlSessionFactory1")
public class Db1MyBatisConfig {
	@Autowired // 自动装配
	@Qualifier("db1") // 指定注入名为db1的组件
	private DataSource db1;

	@Bean
	public SqlSessionFactory sqlSessionFactory1() throws Exception {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(db1);// sqlSessionFactory1使用的数据源为db1
		sqlSessionFactoryBean
				.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper1/*.xml"));
		return sqlSessionFactoryBean.getObject();
	}

	@Bean
	public SqlSessionTemplate sqlSessionTemplate1() throws Exception {
		return new SqlSessionTemplate(sqlSessionFactory1());// sqlSessionTemplate1使用的数据源也是关联到db1
	}
}
