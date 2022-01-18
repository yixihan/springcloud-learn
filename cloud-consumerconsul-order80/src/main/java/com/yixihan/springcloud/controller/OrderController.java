package com.yixihan.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author : yixihan
 * @create : 2022-01-16-16:36
 */
@RestController
@Slf4j
@RequestMapping("/consumer")
public class OrderController {

    public static final String PAYMENT_URL = "http://consul-provider-payment";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/payment/consul")
    public String create () {
        return restTemplate.getForObject (PAYMENT_URL + "/payment/consul", String.class);
    }


}
