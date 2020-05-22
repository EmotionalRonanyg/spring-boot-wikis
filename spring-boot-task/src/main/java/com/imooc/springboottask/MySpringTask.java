package com.imooc.springboottask;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 任务类
 */
@Component
public class MySpringTask {
	/**
	 * 在每分钟的00秒执行
	 */
	@Scheduled(cron = "0 * * * * ?")
	public void jump() throws InterruptedException {
		System.out.println("心跳检测:" + new Date());
	}

	/**
	 * 在每天的00:00:00执行
	 */
	@Scheduled(cron = "0 0 0 * * ?")
	public void stock() throws InterruptedException {
		System.out.println("置满库存:" + new Date());
	}
}
