package com.zdk.springcloud.alibaba.service;

import com.zdk.springcloud.entities.CommonResult;
import com.zdk.springcloud.entities.Payment;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author zdk
 * @Date 2022/11/22 13:13
 */
@Component
public class PaymentFallbackService implements PaymentService{
    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<>(44444, "服务降级返回,------PaymentFallbackService",new Payment(id, "errorSerial"));
    }
}
