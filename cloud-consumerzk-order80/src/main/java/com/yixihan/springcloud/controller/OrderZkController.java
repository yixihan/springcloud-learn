package com.yixihan.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author : yixihan
 * @create : 2022-01-17-18:24
 */
@RestController
@RequestMapping("/consumer")
public class OrderZkController {

    public static final String INVOKE_URL = "http://cloud-provider-payment";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/payment/zk")
    public String paymentInfo () {

        return restTemplate.getForObject (INVOKE_URL + "/payment/zk", String.class);
    }

}
