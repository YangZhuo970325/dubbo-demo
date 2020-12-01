package com.yangzhuo.gmall.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.yangzhuo.gmall.pojo.UserAddress;
import com.yangzhuo.gmall.service.OrderService;
import com.yangzhuo.gmall.service.UserService;

import java.util.Arrays;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Reference //引用远程服务提供者
    // @Reference(url = "127.0.0.1:20882") dubbo直连的方式
    public UserService userService;

    @HystrixCommand(fallbackMethod = "hello")
    @Override
    public List<UserAddress> initOrder(String userID) {
        //查询用户的收货地址
        List<UserAddress> userAddressList = userService.getUserAddressList(userID);
        //为了直观的看到得到的数据，以下内容也可不写
        System.out.println("当前接收到的userId=> "+userID);
        System.out.println("**********");
        System.out.println("查询到的所有地址为：");
        for (UserAddress userAddress : userAddressList) {
            //打印远程服务地址的信息
            System.out.println(userAddress.getUserAddress());
        }
        return userAddressList;
    }

    public List<UserAddress> hello(String userID) {

        return Arrays.asList(new UserAddress(1, "湖北省仙桃市", "1001", "仙桃", "仙桃", "yes"));
    }
}