package com.yixihan.springcloud.controller;

import com.yixihan.springcloud.pojo.CommonResult;
import com.yixihan.springcloud.pojo.Payment;
import com.yixihan.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author : yixihan
 * @create : 2022-01-16-15:40
 */
@Slf4j
@RestController
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

    /**
     * 小坑 : 要加 @RequestBody 这个注解
     */
    @PostMapping("/payment/create")
    public CommonResult<Integer> create(@RequestBody Payment payment) {

        Integer result = paymentService.create (payment);

        log.info ("****插入结果 : {}", result);

        return result > 0 ?
                new CommonResult<> (200, "插入成功, serverPort : " + serverPort, result) :
                new CommonResult<> (444, "插入失败, serverPort : " + serverPort, null);
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {

        Payment result = paymentService.getPaymentById (id);

        log.info ("****查询结果 : {}", result);

        return result != null ?
                new CommonResult<> (200, "查询成功, serverPort : " + serverPort, result) :
                new CommonResult<> (444, "没有对应记录, 查询 ID : " + id + ", serverPort : " + serverPort, null);
    }

    @GetMapping ("/payment/getService")
    public CommonResult<List<String>> getServices () {
        List<String> services = discoveryClient.getServices ();

        for (String element : services) {
            System.out.println(element);
        }

        return new CommonResult<> (200, "获取 services 信息成功", services);
    }

    @GetMapping ("/payment/getInstances")
    public CommonResult<List<ServiceInstance>> getInstances () {
        List<ServiceInstance> instances = discoveryClient.getInstances ("CLOUD-PAYMENT-SERVICE");

        for (ServiceInstance element : instances) {
            System.out.println(element.getServiceId() + "\t" + element.getHost() + "\t" + element.getPort() + "\t"
                    + element.getUri());
        }


        return new CommonResult<> (200, "获取 instances 信息成功", instances);
    }

    @GetMapping ("/payment/getDiscovery")
    public CommonResult<DiscoveryClient> getDiscovery () {

        List<String> services = discoveryClient.getServices ();

        for (String element : services) {
            System.out.println(element);
        }

        List<ServiceInstance> instances = discoveryClient.getInstances ("CLOUD-PAYMENT-SERVICE");

        for (ServiceInstance element : instances) {
            System.out.println(element.getServiceId() + "\t" + element.getHost() + "\t" + element.getPort() + "\t"
                    + element.getUri());
        }


        return new CommonResult<> (200, "获取 discovery 信息成功", discoveryClient);
    }

    @GetMapping(value = "/payment/lb")
    public String getPaymentLB() {
        return serverPort;
    }

    @GetMapping("/payment/feign/timeout")
    public String paymentFeignTimeout () {

        // 暂停三秒钟
        try {
            TimeUnit.SECONDS.sleep (3);
        } catch (InterruptedException e) {
            e.printStackTrace ();
        }

        return serverPort;
    }
}
