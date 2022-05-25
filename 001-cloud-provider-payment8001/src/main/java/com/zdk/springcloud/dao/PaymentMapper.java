package com.zdk.springcloud.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zdk.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author zdk
 * @date 2022/5/25 19:54
 */
@Mapper
public interface PaymentMapper extends BaseMapper<Payment> {
    int create(Payment payment);
    Payment getPaymentById(@Param("id") Long id);
}
