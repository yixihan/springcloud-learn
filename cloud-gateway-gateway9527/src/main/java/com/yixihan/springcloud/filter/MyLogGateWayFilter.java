package com.yixihan.springcloud.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Date;

/**
 * @author : yixihan
 * @create : 2022-01-20-8:07
 */
@Component
@Slf4j
public class MyLogGateWayFilter implements GlobalFilter, Ordered {


    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info ("******come in MyLogGateWayFilter : " + new Date ());
        String uname = exchange.getRequest ().getQueryParams ().getFirst ("uname");

        if (uname == null || "".equals (uname)) {
            log.info ("******用户名为 "+ uname + ", 非法用户");
            exchange.getResponse ().setStatusCode (HttpStatus.NOT_ACCEPTABLE);
            return exchange.getResponse ().setComplete ();
        }
        return chain.filter (exchange);

    }

    @Override
    public int getOrder() {
        return 0;
    }
}
