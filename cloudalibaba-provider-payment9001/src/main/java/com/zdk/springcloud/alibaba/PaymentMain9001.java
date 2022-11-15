package com.zdk.springcloud.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Description
 * @Author zdk
 * @Date 2022/11/15 17:46
 */
@EnableDiscoveryClient
@SpringBootApplication
public class PaymentMain9001{
    public static void main(String[] args){
        SpringApplication.run(PaymentMain9001.class,args);
    }
}
