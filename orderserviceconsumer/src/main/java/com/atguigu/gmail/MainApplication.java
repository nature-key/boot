package com.atguigu.gmail;

import java.io.IOException;

import com.atguigu.gmail.service.OrderService;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class MainApplication {
	
	public static void main(String[] args) throws IOException {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("consumer.xml");
		
		OrderService orderService = applicationContext.getBean(OrderService.class);

		orderService.initOrder("1");
		System.out.println("调用完成....");
		System.in.read();
	}

}
