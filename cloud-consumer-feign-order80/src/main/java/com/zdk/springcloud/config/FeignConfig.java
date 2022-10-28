package com.zdk.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description
 * @Author zdk
 * @Date 2022/10/28 16:51
 */
@Configuration
public class FeignConfig {

    @Bean
    public Logger.Level logLevel(){
//        return Logger.Level.NONE;
//        return Logger.Level.BASIC;
//        return Logger.Level.HEADERS;
        return Logger.Level.FULL;
    }

}
