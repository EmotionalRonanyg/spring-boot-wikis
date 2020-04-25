package com.imooc.springbootjsp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@SpringBootApplication
public class SpringBootJspApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringBootJspApplication.class, args);
	}

	@Bean // 注册视图解析器
	public InternalResourceViewResolver setupViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/jsp/");// 自动添加前缀
		resolver.setSuffix(".jsp");// 自动添加后缀
		return resolver;
	}
}
