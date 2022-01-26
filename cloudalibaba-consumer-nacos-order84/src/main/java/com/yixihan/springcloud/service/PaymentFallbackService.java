package com.yixihan.springcloud.service;

import com.yixihan.springcloud.pojo.CommonResult;
import com.yixihan.springcloud.pojo.Payment;
import org.springframework.stereotype.Component;

/**
 * @author : yixihan
 * @create : 2022-01-26-14:14
 */
@Component
public class PaymentFallbackService implements PaymentService {

    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<>(44444,"服务降级返回,---PaymentFallbackService",new Payment(id, "errorSerial......"));
    }
}
