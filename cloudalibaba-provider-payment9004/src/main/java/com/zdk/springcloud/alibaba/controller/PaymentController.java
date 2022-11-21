package com.zdk.springcloud.alibaba.controller;

import com.zdk.springcloud.entities.CommonResult;
import com.zdk.springcloud.entities.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @Description
 * @Author zdk
 * @Date 2022/11/21 19:47
 */
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    public static HashMap<Long, Payment> hashMap = new HashMap<>();

    static {
        hashMap.put(1L,new Payment(1L, "256asdsadasd51a65s1d65ad165"));
        hashMap.put(2L,new Payment(2L, "j1211434shdas1a65s1d65ad165"));
        hashMap.put(3L,new Payment(3L, "256asdsadasddf11541asdada65"));
    }

    @GetMapping(value = "/paymentSQL/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id){
        Payment payment = hashMap.get(id);
        return new CommonResult<>(200,"from mysql,serverPort:  "+serverPort,payment);
    }

}
