package com.yangzhuo.gmall.service.impl;

import com.yangzhuo.gmall.pojo.UserAddress;
import com.yangzhuo.gmall.service.UserService;

import java.util.List;

public class UserServiceStub implements UserService {

    private UserService userService;

    public UserServiceStub(UserService userService) {
        super();
        this.userService = userService;
    }

    @Override
    public List<UserAddress> getUserAddressList(String userId) {
        System.out.println("本地存根调用...");
        if (Integer.parseInt(userId) > 0) {
            return userService.getUserAddressList(userId);
        }
        return null;
    }
}
