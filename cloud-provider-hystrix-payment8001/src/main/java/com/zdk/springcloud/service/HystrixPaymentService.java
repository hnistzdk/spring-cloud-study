package com.zdk.springcloud.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @Description
 * @Author zdk
 * @Date 2022/10/28 18:03
 */
@Service
public class HystrixPaymentService {

    public String paymentInfoOk(Integer id){
        return "线程池："+Thread.currentThread().getName()+" paymentInfoOk,id:  "+id+"\t"+"欧克欧克";
    }

    public String paymentInfoTimeout(Integer id){
        int time = 3;
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "线程池："+Thread.currentThread().getName()+" paymentInfoTimeout,id:  "+id+"\t"+"欧克欧克 耗时："+time+"秒";
    }

}
