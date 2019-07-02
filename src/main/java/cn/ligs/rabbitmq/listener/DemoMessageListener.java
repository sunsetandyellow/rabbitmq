package cn.ligs.rabbitmq.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;

import cn.ligs.rabbitmq.model.User;

@Component
public class DemoMessageListener {

	@RabbitListener(queues = "My-First-Queue") // 指定Queue队列
	public void firstConsumer(String string) {
		System.out.println("我是:My-First-Queue" + "\tString:" + string);
	}

	@RabbitListener(queues = "My-Two-Queue") // 指定Queue队列
	public void twoConsumer(Integer num) {
		System.out.println("我是:My-Two-Queue" + "\tInteger:" + num);
	}

	@RabbitListener(queues = "My-Three-Queue") // 指定Queue队列
	public void threeConsumer() {
		System.out.println("我是:My-Three-Queue");

	}
	
	@RabbitListener(queues = "My-Request-Test-Queue") // 指定Queue队列
	public void requestTestConsumer(String userJsonString) {
		System.out.println("我是:My-Request-Test-Queue队列");
		System.out.println("json字符串为:" + userJsonString);
        // 将json字符串 转换为 User对象
		User user=JSON.parseObject(userJsonString, User.class);
		System.out.println(user.toString());
	}
}
