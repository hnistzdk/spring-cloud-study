package com.zdk.springcloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping(value = "/testHotKey")
    @SentinelResource(value = "testHotKey",blockHandler = "handleHotKey")
    public String testHotKey(@RequestParam(value = "p1",required = false) String p1,
                             @RequestParam(value = "p2",required = false) String p2){
//        int a = 10/0;
        return "------testHotKey";
    }

    public String handleHotKey(String p1, String p2, BlockException exception){
        return "------handleHotKey---------";
    }

}
