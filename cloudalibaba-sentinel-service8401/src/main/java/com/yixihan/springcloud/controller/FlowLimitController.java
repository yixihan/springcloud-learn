package com.yixihan.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author : yixihan
 * @create : 2022-01-25-14:11
 */
@RestController
@Slf4j
public class FlowLimitController {

    @GetMapping("/testA")
    public String testA() {
        return "------testA";
    }

    @GetMapping("/testB")
    public String testB() {
        return "------testB";
    }

    @GetMapping("/testC")
    public String testC() {
        //暂停几秒钟线程
        try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
        log.info("testC 测试RT");
        return "------testC 测试RT";
    }

    @GetMapping("/testD")
    public String testD() {
        log.info("testD 测试 异常比例");
        int age = 10/0;
        return "------testD 测试 异常比例";
    }

    @GetMapping("/testE")
    public String testE() {
        log.info("testE 测试 异常数");
        int age = 10/0;
        return "------testE 测试 异常数";
    }

    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey",blockHandler = "dealHandler_testHotKey")
    public String testHotKey(
            @RequestParam(value = "p1",required = false) String p1,
            @RequestParam(value = "p2",required = false) String p2) {
        return "------testHotKey";
    }


    public String dealHandler_testHotKey(String p1, String p2, BlockException exception) {
        return "-----dealHandler_testHotKey";
    }

}
