package com.zdk.springcloud.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zdk.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author zdk
 * @date 2022/5/25 19:55
 */
public interface PaymentService extends IService<Payment> {
    int create(Payment payment);
    Payment getPaymentById(@Param("id") Long id);
}
