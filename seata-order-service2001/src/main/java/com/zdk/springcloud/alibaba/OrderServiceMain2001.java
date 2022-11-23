package com.zdk.springcloud.alibaba;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Description
 * @Author zdk
 * @Date 2022/11/23 16:13
 */
@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
@MapperScan("com.zdk.springcloud.alibaba.mapper")
public class OrderServiceMain2001{
    public static void main(String[] args){
        SpringApplication.run(OrderServiceMain2001.class,args);
    }
}
