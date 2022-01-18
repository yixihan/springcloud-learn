package com.yixihan.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author : yixihan
 * @create : 2022-01-18-17:27
 */
@Component
public class PaymentFallbackService implements OrderHystrixService{

    @Override
    public String paymentInfoOk(Integer id) {
        return "----PaymentFallbackService fall back paymentInfoOk";
    }

    @Override
    public String paymentTimeout(Integer id) {
        return "----PaymentFallbackService fall back paymentTimeout";
    }
}
