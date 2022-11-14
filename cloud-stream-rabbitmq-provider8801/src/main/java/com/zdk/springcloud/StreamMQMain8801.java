package com.zdk.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Description
 * @Author zdk
 * @Date 2022/11/14 16:51
 */
@EnableDiscoveryClient
@SpringBootApplication
public class StreamMQMain8801{
    public static void main(String[] args){
        SpringApplication.run(StreamMQMain8801.class,args);
    }
}
