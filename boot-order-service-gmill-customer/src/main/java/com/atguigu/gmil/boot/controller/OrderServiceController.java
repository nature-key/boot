package com.atguigu.gmil.boot.controller;

import com.atguigu.gmail.bean.UserAddress;
import com.atguigu.gmail.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class OrderServiceController {

    @Autowired
    OrderService orderService;

    @ResponseBody
    @RequestMapping("/initorder")
    public List<UserAddress> orderinit(@RequestParam("userId") String userId) {
        List<UserAddress> list = orderService.initOrder(userId);
        return list;
    }
}
