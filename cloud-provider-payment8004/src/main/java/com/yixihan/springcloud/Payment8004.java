package com.yixihan.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author : yixihan
 * @create : 2022-01-17-14:17
 */
@SpringBootApplication
@EnableDiscoveryClient
public class Payment8004 {

    public static void main(String[] args) {
        SpringApplication.run (Payment8004.class, args);
    }
}
