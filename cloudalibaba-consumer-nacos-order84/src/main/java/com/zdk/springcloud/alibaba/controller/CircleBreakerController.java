package com.zdk.springcloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.zdk.springcloud.entities.CommonResult;
import com.zdk.springcloud.entities.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.IllegalFormatCodePointException;

/**
 * @Description
 * @Author zdk
 * @Date 2022/11/21 20:26
 */
@RestController
public class CircleBreakerController {

    @Value("${service-url.nacos-user-service}")
    private String SERVICE_URL;

    @Resource
    private RestTemplate restTemplate;

    @GetMapping(value = "/consumer/fallback/{id}")
    @SentinelResource(value = "fallback")//没有设置
//    @SentinelResource(value = "fallback",fallback = "handlerFallback")//fallback只负责业务异常
//    @SentinelResource(value = "fallback",blockHandler = "blockHandler")//blockHandler只负责sentinel控制台配置违规
//    @SentinelResource(value = "fallback",fallback = "handlerFallback",blockHandler = "blockHandler")
    public CommonResult<Payment> fallback(@PathVariable("id") Long id){
        CommonResult res = restTemplate.getForObject(SERVICE_URL + "/paymentSQL/" + id, CommonResult.class);
        if (id >= 4){
            throw new IllegalArgumentException("IllegalArgumentException,非法参数异常.....");
        }else if (res.getData() == null){
            throw new NullPointerException("NullPointerException,该id没有对应记录，空指针异常.....");
        }
        return res;
    }


}
