package com.yixihan.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author : yixihan
 * @create : 2022-01-18-15:48
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableHystrix
@EnableFeignClients
@EnableEurekaClient
public class OrderHystrixMain80 {

    public static void main(String[] args) {
        SpringApplication.run (OrderHystrixMain80.class, args);
    }
}
