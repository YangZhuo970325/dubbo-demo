package com.yangzhuo.gmall.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.yangzhuo.gmall.pojo.UserAddress;
import com.yangzhuo.gmall.service.UserService;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

//负载均衡模式：  1.random：（基于权重）随机    2.roundrobin：轮询   3.leastactive：最少被使用
@Service(loadbalance = "consistenthash") //dubbo的服务暴露
@Component
public class UserServiceImpl implements UserService {

    @HystrixCommand //此方法由hystrix来代理
    @Override
    public List<UserAddress> getUserAddressList(String userId) {

        UserAddress address1 = new UserAddress(1, "河南省郑州巩义市宋陵大厦2F", "1", "安然", "150360313x", "Y");
        UserAddress address2 = new UserAddress(2, "北京市昌平区沙河镇沙阳路", "1", "情话", "1766666395x", "N");

        //模拟异常
        if (Math.random() > 0.5) {
            throw new RuntimeException();
        }

        return Arrays.asList(address1, address2);
    }
}
