package com.yixihan.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.yixihan.springcloud.service.OrderHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author : yixihan
 * @create : 2022-01-18-15:52
 */
@RestController
@RequestMapping("/consumer")
@Slf4j
@DefaultProperties(defaultFallback = "paymentGlobalFallbackMethod")
public class OrderHystrixController {

    @Resource
    private OrderHystrixService orderHystrixService;

    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentInfoOk (@PathVariable("id") Integer id) {
        String result = orderHystrixService.paymentInfoOk (id);
        log.info (result);
        return result;
    }


    /**
     * 若 @HystrixCommand 注解没有指定 fallbackMethod, 则会调用全局的 fallbackMethod 方法
     */
    @GetMapping("/payment/hystrix/timeout/{id}")
//    @HystrixCommand(fallbackMethod = "paymentTimeOutFallbackMethod",commandProperties = {
//            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="1500")
//    })
    @HystrixCommand
    public String paymentTimeout (@PathVariable("id") Integer id) {
//        int age = 10 / 0;
        String result = orderHystrixService.paymentTimeout (id);
        log.info (result);
        return result;
    }

    public String paymentTimeOutFallbackMethod (Integer id) {
        return "我是消费者80,对方支付系统繁忙请10秒钟后再试或者自己运行出错请检查自己,o(╥﹏╥)o";
    }


    /**
     * 全局 fallback 方法
     */
    public String paymentGlobalFallbackMethod () {
        return "Global异常处理信息，请稍后再试，/(ㄒoㄒ)/~~";
    }

}
