package com.zdk.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author zdk
 * @Date 2022/11/14 17:51
 */
@Component
@EnableBinding(Sink.class) //这里标志这个类是消息的入口 即进入消费者
public class ReceiveMessageListenerController {

    @Value("${server.port}")
    private String serverPort;

    @StreamListener(Sink.INPUT)
    public void input(Message<String> message){
        System.out.println("消费者2号,----->接收到的消息："+message.getPayload()+"\t  port："+serverPort);
    }
}
