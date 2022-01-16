package com.yixihan.springcloud.service;

import com.yixihan.springcloud.mapper.PaymentMapper;
import com.yixihan.springcloud.pojo.Payment;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author : yixihan
 * @create : 2022-01-16-15:36
 */
@Service
public class PaymentServiceImpl implements PaymentService{

    @Resource
    private PaymentMapper paymentMapper;


    @Override
    public Integer create(Payment payment) {
        return paymentMapper.create (payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentMapper.getPaymentById (id);
    }
}
