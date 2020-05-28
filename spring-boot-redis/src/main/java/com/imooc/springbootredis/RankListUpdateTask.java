package com.imooc.springbootredis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;

/**
 * 排行榜更新任务
 */
@Component
public class RankListUpdateTask {
	@Autowired
	private GoodsRankService goodsRankService;

	/**
	 * 容器启动后马上执行，且每1秒执行1次
	 */
	@Scheduled(initialDelay = 0, fixedRate = 1000)
	public void execute() throws InterruptedException, JsonProcessingException {
		goodsRankService.updateRankList();
	}
}
