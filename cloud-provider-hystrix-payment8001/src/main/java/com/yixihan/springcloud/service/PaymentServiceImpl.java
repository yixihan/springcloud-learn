package com.yixihan.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author : yixihan
 * @create : 2022-01-18-14:39
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    /**
     * 正常访问, 肯定 ok
     *
     * @param id id
     * @return info
     */
    @Override
    public String paymentInfoOk(Integer id) {
        return "线程池 : " + Thread.currentThread ().getName () + " paymentInfoOk, id : " + id + "\t hhhh";
    }

    /**
     * 超时访问
     *
     * @param id id
     * @return info
     */
    @Override
    @HystrixCommand(fallbackMethod = "paymentInfoTimeoutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    public String paymentTimeout(Integer id) {
        int timeNumber = 5;
        try {
            TimeUnit.SECONDS.sleep (timeNumber);
        } catch (InterruptedException e) {
            e.printStackTrace ();
        }
        return "线程池 : " + Thread.currentThread ().getName () + " paymentTimeout, id : " + id + "\t hhhh, 耗时 " + timeNumber + " s";
    }

    public String paymentInfoTimeoutHandler(Integer id) {

        return "线程池 : " + Thread.currentThread ().getName () + " 调用接口超时或异常, 请稍后再试, " +
                "id : " + id + "\t xxxxx ";
    }

}
