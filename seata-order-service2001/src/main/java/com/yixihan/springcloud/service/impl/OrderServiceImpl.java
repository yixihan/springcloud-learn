package com.yixihan.springcloud.service.impl;

import com.yixihan.springcloud.mapper.OrderMapper;
import com.yixihan.springcloud.pojo.Order;
import com.yixihan.springcloud.service.AccountService;
import com.yixihan.springcloud.service.OrderService;
import com.yixihan.springcloud.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author : yixihan
 * @create : 2022-01-28-12:12
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderMapper orderMapper;

    @Resource
    private AccountService accountService;

    @Resource
    private StorageService storageService;

    /**
     * 创建订单->调用库存服务扣减库存->调用账户服务扣减账户余额->修改订单状态
     * 简单说：
     * 下订单->减库存->减余额->改状态
     */
    @Override
    @GlobalTransactional(name = "fsp-create-order",rollbackFor = Exception.class)
    public void create(Order order) {

        // 1. 新建订单
        log.info (" ---> 开始新建订单 ---start");
        orderMapper.create (order);

        // 2. 扣减库存
        log.info (" ---> 订单微服务开始调用库存, 做扣减 ---start");
        storageService.decrease (order.getProductId (), order.getCount ());
        log.info (" ---> 订单微服务开始调用库存, 做扣减 ---end");

        // 3. 扣减账户
        log.info (" ---> 订单微服务开始调用账号, 做扣减 Money ---start");
        accountService.decrease (order.getUserId (), order.getMoney ());
        log.info (" ---> 订单微服务开始调用账号, 做扣减 Money ---end");

        // 4. 修改订单的状态, 0 -> 1 (1 代表已经完成)
        log.info ("---> 修改订单状态 ---start");
        orderMapper.update (order.getUserId (), 0);
        log.info ("---> 修改订单状态 ---end");

        log.info ("---> 下订单, 结束啦~ ---end");
    }
}
