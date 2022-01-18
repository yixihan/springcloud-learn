package com.yixihan.springcloud.controller;

import com.yixihan.springcloud.pojo.CommonResult;
import com.yixihan.springcloud.pojo.Payment;
import com.yixihan.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author : yixihan
 * @create : 2022-01-18-10:44
 */
@RestController
@RequestMapping("/consumer")
@Slf4j
public class OrderFeignController {

    @Resource
    private PaymentFeignService paymentFeignService;


    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getPaymentById (@PathVariable("id") Long id) {
        return paymentFeignService.getPaymentById (id);
    }

    @GetMapping("/payment/feign/timeout")
    public String paymentFeignTimeout () {
        // openfeign - ribbon, 客户端一般默认等待一秒钟
        return paymentFeignService.paymentFeignTimeout ();
    }
}
