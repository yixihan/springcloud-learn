package com.yixihan.springcloud.service;

import com.yixihan.springcloud.pojo.Order;

/**
 * @author : yixihan
 * @create : 2022-01-28-12:11
 */
public interface OrderService {

    /**
     * 创建订单
     */
    void create(Order order);
}
