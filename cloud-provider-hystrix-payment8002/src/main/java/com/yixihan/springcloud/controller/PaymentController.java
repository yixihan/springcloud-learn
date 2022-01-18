package com.yixihan.springcloud.controller;

import com.yixihan.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author : yixihan
 * @create : 2022-01-18-14:44
 */
@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value ("${server.port")
    private String serverPort;

    @GetMapping("/hystrix/ok/{id}")
    String paymentInfoOk (@PathVariable ("id") Integer id) {
        String result = paymentService.paymentInfoOk (id);

        log.info (result);
        return result;
    }

    @GetMapping("/hystrix/timeout/{id}")
    public String paymentTimeout (@PathVariable ("id")Integer id) {
        String result = paymentService.paymentTimeout (id);

        log.info (result);
        return result;
    }

}
