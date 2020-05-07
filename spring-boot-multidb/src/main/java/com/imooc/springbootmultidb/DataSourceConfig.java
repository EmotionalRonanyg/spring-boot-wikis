package com.imooc.springbootmultidb;

import java.sql.SQLException;

import javax.sql.DataSource;
import javax.transaction.UserTransaction;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.transaction.jta.JtaTransactionManager;

import com.atomikos.icatch.jta.UserTransactionImp;
import com.atomikos.icatch.jta.UserTransactionManager;
import com.microsoft.sqlserver.jdbc.SQLServerXADataSource;
import com.mysql.cj.jdbc.MysqlXADataSource;

/**
 * 数据源配置类
 */
@Configuration // 标注为配置类
public class DataSourceConfig {
	// 注入数据源1配置项
	@Value("${spring.datasource.db1.jdbc-url}")
	private String db1_url;
	@Value("${spring.datasource.db1.username}")
	private String db1_username;
	@Value("${spring.datasource.db1.password}")
	private String db1_password;
	// 注入数据源2配置项
	@Value("${spring.datasource.db2.jdbc-url}")
	private String db2_url;
	@Value("${spring.datasource.db2.username}")
	private String db2_username;
	@Value("${spring.datasource.db2.password}")
	private String db2_password;

	/**
	 * 数据源1
	 */
	@Bean // 返回值注册为组件
	public DataSource db1() throws SQLException {
		MysqlXADataSource dataSource = new MysqlXADataSource();
		dataSource.setUrl(db1_url);
		dataSource.setUser(db1_username);
		dataSource.setPassword(db1_password);
		AtomikosDataSourceBean atomikosDataSourceBean = new AtomikosDataSourceBean();
		atomikosDataSourceBean.setXaDataSource(dataSource);
		atomikosDataSourceBean.setUniqueResourceName("db1");
		return atomikosDataSourceBean;

	}

	/**
	 * 数据源2
	 */
	@Bean // 返回值注册为组件
	public DataSource db2() {
		SQLServerXADataSource dataSource = new SQLServerXADataSource();
		dataSource.setURL(db2_url);
		dataSource.setUser(db2_username);
		dataSource.setPassword(db2_password);
		AtomikosDataSourceBean atomikosDataSourceBean = new AtomikosDataSourceBean();
		atomikosDataSourceBean.setXaDataSource(dataSource);
		atomikosDataSourceBean.setUniqueResourceName("db2");
		return atomikosDataSourceBean;
	}

	/**
	 * 分布式事务管理器
	 */
	@Bean(name = "jtaTransactionManager")
	public JtaTransactionManager jtaTransactionManager() {
		UserTransactionManager userTransactionManager = new UserTransactionManager();
		UserTransaction userTransaction = new UserTransactionImp();
		return new JtaTransactionManager(userTransaction, userTransactionManager);
	}
}
