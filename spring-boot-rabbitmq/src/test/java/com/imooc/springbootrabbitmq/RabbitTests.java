package com.imooc.springbootrabbitmq;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 测试
 */
@SpringBootTest
class RabbitTests {
	@Autowired
	private RabbitTemplate rabbitTemplate;

	@Test
	void testSendMsg() {
		// 发送消息 参数分别为：交换机名称、路由键、消息内容
		rabbitTemplate.convertAndSend("exchange-topic", "apple", "苹果来了10斤");
		rabbitTemplate.convertAndSend("exchange-topic", "banana", "香蕉来了5斤");
		rabbitTemplate.convertAndSend("exchange-topic", "apple.banana", "苹果来了8斤;香蕉来了20斤");
	}
}
