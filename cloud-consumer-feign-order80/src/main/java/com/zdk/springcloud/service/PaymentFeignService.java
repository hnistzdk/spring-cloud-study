package com.zdk.springcloud.service;

import com.zdk.springcloud.entities.CommonResult;
import com.zdk.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Description
 * @Author zdk
 * @Date 2022/10/26 17:40
 */
@Component
//指定Feign调用的服务的名称(payment8001的名称)
@FeignClient(value = "cloud-payment-service")
public interface PaymentFeignService {

    /**
     * 指定接口
     * @param id
     * @return
     */
    @GetMapping("/payment/get/{id}")
    CommonResult<Payment> getById(@PathVariable("id") Long id);
}
