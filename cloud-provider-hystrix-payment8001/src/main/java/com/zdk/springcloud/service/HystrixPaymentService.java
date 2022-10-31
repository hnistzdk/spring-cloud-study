package com.zdk.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
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

    @HystrixCommand(fallbackMethod = "paymentInfoTimeoutHandler", commandProperties =
            {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "2000")})
    public String paymentInfoTimeout(Integer id){
//        int a = 10/0;
        int time = 5;
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "线程池："+Thread.currentThread().getName()+" paymentInfoTimeout,id:  "+id+"\t"+"欧克欧克 耗时："+time+"秒";
    }

    public String paymentInfoTimeoutHandler(Integer id){
        return "线程池："+Thread.currentThread().getName()+"id:"+id+"  超时或运行报错->服务降级咯~~~~~";
    }

}
