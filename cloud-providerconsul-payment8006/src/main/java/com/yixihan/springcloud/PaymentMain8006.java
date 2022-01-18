package com.yixihan.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author : yixihan
 * @create : 2022-01-18-7:38
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentMain8006 {

    public static void main(String[] args) {
        SpringApplication.run (PaymentMain8006.class, args);
    }
}
