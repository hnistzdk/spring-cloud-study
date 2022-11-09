package com.zdk.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;
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

    /**
     * =========服务熔断
     */
    @HystrixCommand(fallbackMethod = "paymentCircuitBreakerFallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),//是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),//请求次数
            //请求窗口期：熔断多少秒后再去接收尝试请求(再去接收如果遇到请求成功 即恢复正常调用)
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "20000"),
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"),//失败率达到多少后跳闸
            //这里意思是：在10秒内，如果10次请求中有6次请求都失败了，就会进行断路
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        if (id < 0){
            throw new RuntimeException("******id 不能是负数");
        }
        String serialNUmber = IdUtil.simpleUUID();
        return Thread.currentThread().getName()+"\t"+"调用成功，流水号："+serialNUmber;
    }

    public String paymentCircuitBreakerFallback(@PathVariable("id") Integer id){
        return "******id 不能是负数，请稍后再试o(╥﹏╥)o~  id："+id;
    }


}
