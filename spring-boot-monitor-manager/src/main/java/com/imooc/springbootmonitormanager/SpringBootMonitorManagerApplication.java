package com.imooc.springbootmonitormanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import de.codecentric.boot.admin.server.config.EnableAdminServer;

@SpringBootApplication
@EnableAdminServer // 开启监控管理
public class SpringBootMonitorManagerApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringBootMonitorManagerApplication.class, args);
	}
}
