package com.imooc.springboottransaction;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.imooc.springboottransaction") // 指定MyBatis扫描的包，以便将数据访问接口注册为bean
public class SpringBootTransactionApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringBootTransactionApplication.class, args);
	}
}
