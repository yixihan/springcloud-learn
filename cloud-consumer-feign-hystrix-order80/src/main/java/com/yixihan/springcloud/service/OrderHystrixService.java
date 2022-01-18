package com.yixihan.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author : yixihan
 * @create : 2022-01-18-15:50
 */
@Component
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT", fallback = PaymentFallbackService.class)
public interface OrderHystrixService {

    @GetMapping("/payment/hystrix/ok/{id}")
    String paymentInfoOk (@PathVariable("id") Integer id);

    @GetMapping("/payment/hystrix/timeout/{id}")
    String paymentTimeout (@PathVariable("id") Integer id);
}
