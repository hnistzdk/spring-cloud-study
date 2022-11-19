package com.zdk.springcloud.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Description
 * @Author zdk
 * @Date 2022/11/19 15:21
 */
@EnableDiscoveryClient
@SpringBootApplication
public class MainApp8401{
    public static void main(String[] args){
        SpringApplication.run(MainApp8401.class,args);
    }
}
