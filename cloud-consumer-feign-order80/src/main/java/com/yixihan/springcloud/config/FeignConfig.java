package com.yixihan.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author : yixihan
 * @create : 2022-01-18-11:35
 */
@Configuration
public class FeignConfig {

    @Bean
    Logger.Level feignLoggerLevel () {
        return Logger.Level.FULL;
    }
}
