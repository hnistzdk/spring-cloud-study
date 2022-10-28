package com.zdk.springcloud.controller;

import com.zdk.springcloud.service.HystrixPaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author zdk
 * @Date 2022/10/28 18:07
 */
@Slf4j
@RestController
public class HystrixPaymentController {

    @Autowired
    private HystrixPaymentService hystrixPaymentService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentInfoOk(@PathVariable Integer id){
        String result = hystrixPaymentService.paymentInfoOk(id);
        log.info("*****result："+result);
        return result;
    }

    @GetMapping("/payment/hystrix/timeout/{id}")
    public String paymentInfoTimeout(@PathVariable Integer id){
        String result = hystrixPaymentService.paymentInfoTimeout(id);
        log.info("*****result："+result);
        return result;
    }


}
