package com.yixihan.springcloud.controller;

import com.yixihan.springcloud.lb.LoadBalancer;
import com.yixihan.springcloud.pojo.CommonResult;
import com.yixihan.springcloud.pojo.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/**
 * @author : yixihan
 * @create : 2022-01-16-16:36
 */
@RestController
@Slf4j
@RequestMapping("/consumer")
public class OrderController {

//    public static final String PAYMENT_URL = "http://localhost:8001";
    /**
     * localhost:8001 -> 微服务名, 即 eureka 控制台上显示的名字 (CLOUD-PAYMENT-SERVICE)
     */
    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private DiscoveryClient discoveryClient;

    @Resource
    private LoadBalancer loadBalancer;

    @GetMapping("/payment/create")
    public CommonResult<Payment> create(Payment payment) {
        return restTemplate.postForObject (PAYMENT_URL + "/payment/create", payment, CommonResult.class);
    }


    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {
        return restTemplate.getForObject (PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
    }

    @GetMapping("/payment/getService")
    public CommonResult<List<String>> getServices() {

        return restTemplate.getForObject (PAYMENT_URL + "/payment/getService", CommonResult.class);
    }

    @GetMapping("/payment/getInstances")
    public CommonResult<List<ServiceInstance>> getInstances() {

        return restTemplate.getForObject (PAYMENT_URL + "/payment/getInstances", CommonResult.class);
    }

    @GetMapping("/payment/getDiscovery")
    public CommonResult<DiscoveryClient> getDiscovery() {
        return restTemplate.getForObject (PAYMENT_URL + "/payment/getDiscovery", CommonResult.class);
    }

    @GetMapping("/payment/getForEntity/get/{id}")
    public CommonResult<Payment> getPayment2(@PathVariable("id") Long id) {
        ResponseEntity<CommonResult> entity = restTemplate.getForEntity (PAYMENT_URL + "/payment/get/" + id, CommonResult.class);

        if (entity.getStatusCode ().is2xxSuccessful ()) {
            log.info (entity.getStatusCode () + "\t" + entity.getHeaders () + "\t" + entity.getBody ());
            return entity.getBody ();
        } else {
            return new CommonResult<> (444, "操作失败");
        }
    }

    @GetMapping("/payment/createForEntity")
    public CommonResult<Payment> createForEntity(Payment payment) {
        ResponseEntity<CommonResult> entity = restTemplate.postForEntity (PAYMENT_URL + "/payment/create", payment, CommonResult.class);

        if (entity.getStatusCode ().is2xxSuccessful ()) {
            log.info (entity.getStatusCode () + "\t" + entity.getHeaders () + "\t" + entity.getBody ());
            return entity.getBody ();
        } else {
            return new CommonResult<> (444, "操作失败");
        }
    }

    @GetMapping("/payment/lb")
    public String getPaymentLB() {
        List<ServiceInstance> instances = discoveryClient.getInstances ("CLOUD-PAYMENT-SERVICE");

        if (instances == null || instances.size () <= 0) {
            return null;
        }
        ServiceInstance serviceInstance = loadBalancer.instances (instances);
        URI uri = serviceInstance.getUri ();

        return restTemplate.getForObject (uri + "/payment/lb", String.class);
    }

}
