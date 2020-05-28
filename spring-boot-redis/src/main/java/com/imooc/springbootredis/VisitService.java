package com.imooc.springbootredis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * 网站访问统计服务类
 */
@Service
public class VisitService {
	// 设定访问次数Redis键名
	private final static String KEY = "visit_count";

	// 注入redisTemplate操作Redis
	@Autowired
	private RedisTemplate<String, String> redisTemplate;

	// 获取当前访问次数
	public String getCurrentCount() {
		String count = redisTemplate.opsForValue().get(KEY);
		if (count == null || "".equals(count)) {
			redisTemplate.opsForValue().set(KEY, "0");
			return "0";
		}
		return count;
	}

	// 访问次数加1
	public void addCount() {
		redisTemplate.opsForValue().increment(KEY, 1);
	}
}
