package com.zdk.springcloud.service.impl;

import cn.hutool.core.util.IdUtil;
import com.zdk.springcloud.service.IMessageProvider;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

import javax.annotation.Resource;

/**
 * @Description
 * @Author zdk
 * @Date 2022/11/14 16:56
 * @EnableBinding(value = Source.class) 标志这个类是消息源，即发送者
 */
@EnableBinding(value = Source.class)
public class MessageProviderImpl implements IMessageProvider {

    @Resource
    private MessageChannel output;

    @Override
    public String send() {
        String serial = IdUtil.simpleUUID();
        output.send(MessageBuilder.withPayload(serial).build());
        System.out.println("***发送消息："+serial);
        return serial;
    }
}
