package com.yixihan.springcloud.controller;

import com.yixihan.springcloud.pojo.CommonResult;
import com.yixihan.springcloud.pojo.Order;
import com.yixihan.springcloud.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author : yixihan
 * @create : 2022-01-28-12:40
 */
@RestController
@Slf4j
public class OrderController {

    @Resource
    private OrderService orderService;

    @GetMapping("/order/create")
    public CommonResult create (Order order) {
        orderService.create (order);
        return new CommonResult (200, "订单创建完成~");
    }
}
