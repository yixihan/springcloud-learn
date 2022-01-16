package com.yixihan.springcloud.controller;

import com.yixihan.springcloud.pojo.CommonResult;
import com.yixihan.springcloud.pojo.Payment;
import com.yixihan.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author : yixihan
 * @create : 2022-01-16-15:40
 */
@Slf4j
@RestController
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    /**
     * 小坑 : 要加 @RequestBody 这个注解
     */
    @PostMapping("/payment/create")
    public CommonResult<Integer> create(@RequestBody Payment payment) {

        Integer result = paymentService.create (payment);

        log.info ("****插入结果 : {}", result);

        return result > 0 ?
                new CommonResult<> (200, "插入成功", result) :
                new CommonResult<> (444, "插入失败", null);
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {

        Payment result = paymentService.getPaymentById (id);

        log.info ("****查询结果 : {}", result);

        return result != null ?
                new CommonResult<> (200, "查询成功", result) :
                new CommonResult<> (444, "没有对应记录, 查询 ID : " + id, null);
    }


}
