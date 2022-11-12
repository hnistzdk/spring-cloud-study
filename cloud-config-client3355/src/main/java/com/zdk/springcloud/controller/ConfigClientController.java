package com.zdk.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author zdk
 * @Date 2022/11/12 18:56
 */
@RestController
@RefreshScope
public class ConfigClientController {
    @Value("${server.name}")
    private String serverName;

    @GetMapping("/configInfo")
    public String getConfigInfo(){
        return serverName;
    }
}
