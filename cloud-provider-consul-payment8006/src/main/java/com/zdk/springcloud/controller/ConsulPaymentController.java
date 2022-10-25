package com.zdk.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @Description
 * @Author zdk
 * @Date 2022/10/25 18:07
 */
@Slf4j
@RestController
public class ConsulPaymentController {
    @Value("${server.port}")
    private String serverPort;

    @GetMapping("payment/consul")
    public String paymentZk(){
        return "springcloud with consul: "+serverPort+"\t"+ UUID.randomUUID().toString();
    }
}
