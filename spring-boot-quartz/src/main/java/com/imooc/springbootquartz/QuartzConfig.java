package com.imooc.springbootquartz;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;

/**
 * 定时任务配置
 */
@Configuration
public class QuartzConfig {
	/**
	 * 配置JobDetail工厂组件，生成的JobDetail指向discountJob的execute()方法
	 */
	@Bean
	MethodInvokingJobDetailFactoryBean jobFactoryBean() {
		MethodInvokingJobDetailFactoryBean bean = new MethodInvokingJobDetailFactoryBean();
		bean.setTargetBeanName("discountJob");
		bean.setTargetMethod("execute");
		return bean;
	}
	/**
	 * 触发器工厂
	 */
	@Bean
	CronTriggerFactoryBean cronTrigger() {
		CronTriggerFactoryBean bean = new CronTriggerFactoryBean();
		// Corn表达式设定执行时间规则
		bean.setCronExpression("0 0 8 ? * 7");
		// 执行JobDetail
		bean.setJobDetail(jobFactoryBean().getObject());
		return bean;
	}
}
