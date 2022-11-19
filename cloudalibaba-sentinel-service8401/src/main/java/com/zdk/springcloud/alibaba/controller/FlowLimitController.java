package com.zdk.springcloud.alibaba.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @Description
 * @Author zdk
 * @Date 2022/11/19 15:22
 */
@RestController
@Slf4j
public class FlowLimitController {

    @GetMapping(value = "/testA")
    public String testA(){
        /*try{
            TimeUnit.SECONDS.sleep(1);
        }catch(InterruptedException e){
            throw new RuntimeException(e);
        }*/
        return "------testA";
    }

    @GetMapping(value = "/testB")
    public String testB(){
        try{
            TimeUnit.SECONDS.sleep(3);
        }catch(InterruptedException e){
            throw new RuntimeException(e);
        }
        log.info(Thread.currentThread().getName()+"\t"+"------testB");
        return "------testB";
    }

}
