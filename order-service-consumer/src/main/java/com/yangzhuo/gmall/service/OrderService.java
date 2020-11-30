package com.yangzhuo.gmall.service;

import com.yangzhuo.gmall.pojo.UserAddress;

import java.util.List;

public interface OrderService {
    /**
     * 初始化订单
     * @param userID
     */
    public List<UserAddress> initOrder(String userID);
}
