package com.atguigu.gmil.boot.service.imp;

import java.util.Arrays;
import java.util.List;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.gmail.bean.UserAddress;
import com.atguigu.gmail.service.OrderService;
import com.atguigu.gmail.service.UserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



/**
 * 1、将服务提供者注册到注册中心（暴露服务）
 * 		1）、导入dubbo依赖（2.6.2）\操作zookeeper的客户端(curator)
 * 		2）、配置服务提供者
 *
 * 2、让服务消费者去注册中心订阅服务提供者的服务地址
 * @author lfy
 *
 */
@Service
public class OrderServiceImpl implements OrderService {

//	@Autowired
	@Reference(loadbalance = "random")//(url = "127.0.0.1:20882")
	UserService userService;
	@HystrixCommand(fallbackMethod = "hello")
	@Override
	public List<UserAddress> initOrder(String userId) {
//		 TODO Auto-generated method stub
		System.out.println("用户id："+userId);
		//1、查询用户的收货地址
		List<UserAddress> addressList = userService.getUserAddressList(userId);
		for (UserAddress userAddress : addressList) {
			System.out.println(userAddress.getUserAddress());
		}
		return addressList;
	}

	public List<UserAddress> hello(String userId){

		return Arrays.asList(new UserAddress(10, "北京市昌平区宏福科技园综合楼3层测试", "测试", "刘虎", "010-56253825", "Y"));
	}

}
