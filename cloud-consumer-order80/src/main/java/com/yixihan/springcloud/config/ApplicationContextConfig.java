package com.yixihan.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author : yixihan
 * @create : 2022-01-16-16:47
 */
@Configuration
public class ApplicationContextConfig {

    /**
     * 使用 @LoadBalanced 注解赋予 RestTemplate 负载均衡的能力
     */
    @Bean("getRestTemplate")
    @LoadBalanced
    public RestTemplate getRestTemplate () {
        return new RestTemplate ();
    }
}
