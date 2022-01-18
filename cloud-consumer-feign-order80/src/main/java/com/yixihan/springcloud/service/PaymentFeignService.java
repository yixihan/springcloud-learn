package com.yixihan.springcloud.service;

import com.yixihan.springcloud.pojo.CommonResult;
import com.yixihan.springcloud.pojo.Payment;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author : yixihan
 * @create : 2022-01-18-10:40
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {

    @GetMapping("/payment/get/{id}")
    CommonResult<Payment> getPaymentById (@PathVariable("id") Long id);

    @GetMapping("/payment/feign/timeout")
    String paymentFeignTimeout ();
}
