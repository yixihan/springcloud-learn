package com.yixihan.springcloud.service;

/**
 * @author : yixihan
 * @create : 2022-01-18-14:39
 */
public interface PaymentService {

    String paymentInfoOk (Integer id);

    String paymentTimeout (Integer id);

    String paymentCircuitBreaker(Integer id);
}
