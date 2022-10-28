package com.zdk.springcloud.controller;

import com.zdk.springcloud.entities.CommonResult;
import com.zdk.springcloud.entities.Payment;
import com.zdk.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description
 * @Author zdk
 * @Date 2022/10/26 17:46
 */
@Slf4j
@RestController
public class OrderFeignController {

    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult<Payment> findPaymentById(@PathVariable("id") Long id) {
        return paymentFeignService.getById(id);
    }

    @GetMapping(value = "/consumer/payment/timeout")
    public String timeout() {
        return paymentFeignService.timeout();
    }

}
