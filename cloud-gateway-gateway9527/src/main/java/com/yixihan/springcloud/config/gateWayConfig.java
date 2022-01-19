package com.yixihan.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author : yixihan
 * @create : 2022-01-19-10:27
 */
@Configuration
public class gateWayConfig {

    @Bean
    public RouteLocator routers (RouteLocatorBuilder builder) {
        RouteLocatorBuilder.Builder routes = builder.routes ();

        routes.route ("path_route_guonei",
                r -> r.path("/guonei").uri("http://news.baidu.com/guonei")).build ();

        routes.route ("path_route_guoji",
                r -> r.path ("/guoji").uri ("http://news.baidu.com/guoji")).build ();

        return routes.build ();
    }

}
