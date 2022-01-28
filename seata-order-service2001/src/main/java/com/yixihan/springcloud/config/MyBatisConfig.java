package com.yixihan.springcloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author : yixihan
 * @create : 2022-01-28-12:42
 */
@Configuration
@MapperScan("com.yixihan.springcloud.mapper")
public class MyBatisConfig {
}
