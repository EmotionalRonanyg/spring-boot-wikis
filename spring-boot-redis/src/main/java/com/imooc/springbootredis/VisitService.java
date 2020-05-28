package com.imooc.springbootredis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * 网站访问统计服务类
 */
@Service
public class VisitService {
	private final static String KEY = "visit_count";

	// 注入redisTemplate操作Redis
	@Autowired
	private RedisTemplate<String, String> redisTemplate;

	// 获取当前访问次数
	public Long getCurrentCount() {
		String count = redisTemplate.opsForValue().get(KEY);
		if (count == null || "".equals(count)) {
			return 0L;
		}
		return Long.parseLong(count);
	}

	// 访问次数加1
	public void addCount() {
		String count = redisTemplate.opsForValue().get(KEY);
		if (count == null || "".equals(count)) {
			redisTemplate.opsForValue().set(KEY, "1");
			return;
		}
		redisTemplate.opsForValue().set(KEY, String.valueOf(Long.parseLong(count) + 1));
	}
}
