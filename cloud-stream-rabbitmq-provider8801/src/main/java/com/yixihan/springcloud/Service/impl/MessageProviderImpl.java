package com.yixihan.springcloud.Service.impl;

import com.yixihan.springcloud.Service.IMessageProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author : yixihan
 * @create : 2022-01-20-13:51
 */
@EnableBinding(Source.class) // 定义消息的推送管道
@Slf4j
public class MessageProviderImpl implements IMessageProvider {

    /**
     * 消息发送管道
     */
    @Resource
    private MessageChannel output;

    @Override
    public String send() {

        String serial = UUID.randomUUID ().toString ();
        output.send (MessageBuilder.withPayload (serial).build ()); // 创建并发送消息
        log.info ("***serial: " + serial);

        return serial;
    }
}
