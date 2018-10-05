package com.atguigu.gmail.service.imp;

import com.atguigu.gmail.bean.UserAddress;
import com.atguigu.gmail.service.UserService;
import org.springframework.util.StringUtils;

import java.util.List;

public class UserServiceStd implements UserService{

    private  final  UserService userService;

    public UserServiceStd(UserService userService) {
        this.userService = userService;
    }

    @Override
    public List<UserAddress> getUserAddressList(String userId) {
        System.out.println("userservice");
        if(!StringUtils.isEmpty(userId)){
            return userService.getUserAddressList(userId);
        }
        return null;
    }
}
