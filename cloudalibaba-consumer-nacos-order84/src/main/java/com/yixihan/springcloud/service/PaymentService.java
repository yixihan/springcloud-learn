package com.yixihan.springcloud.service;

import com.yixihan.springcloud.pojo.CommonResult;
import com.yixihan.springcloud.pojo.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author : yixihan
 * @create : 2022-01-26-14:14
 */
@FeignClient(value = "nacos-payment-provider", fallback = PaymentFallbackService.class)//调用中关闭9003服务提供者
public interface PaymentService {

    @GetMapping(value = "/paymentSQL/{id}")
    CommonResult<Payment> paymentSQL(@PathVariable("id") Long id);
}
