package com.zdk.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Description
 * @Author zdk
 * @Date 2022/11/13 18:40
 */
@EnableDiscoveryClient
@SpringBootApplication
public class ConfigClientMain3366{
    public static void main(String[] args){
        SpringApplication.run(ConfigClientMain3366.class,args);
    }
}
