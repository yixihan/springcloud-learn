package com.yixihan.springcloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author : yixihan
 * @create : 2022-01-16-16:47
 */
@Configuration
public class ApplicationContextConfig {

    @Bean("getRestTemplate")
    public RestTemplate getRestTemplate () {
        return new RestTemplate ();
    }
}
