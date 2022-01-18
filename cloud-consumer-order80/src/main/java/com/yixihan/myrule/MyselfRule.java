package com.yixihan.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author : yixihan
 * @create : 2022-01-18-8:51
 */
@Configuration
public class MyselfRule {

    @Bean
    public IRule myRule () {
        // 定义为随机
        return new RandomRule ();
    }
}
