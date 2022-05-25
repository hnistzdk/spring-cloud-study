package com.zdk.springcloud.controller;

import com.zdk.springcloud.entities.CommonResult;
import com.zdk.springcloud.entities.Payment;
import com.zdk.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author zdk
 * @date 2022/5/25 20:04
 */
@Slf4j
@RestController
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @PostMapping(value = "/create")
    public CommonResult<Object> create(Payment payment){
        int result = paymentService.create(payment);
        log.info("========== 插入结果：{}",result);
        if (result > 0){
            return new CommonResult<>(200, "插入数据库成功",result);
        }else {
            return new CommonResult<>(444, "插入数据库失败");
        }
    }
    @GetMapping("/get/{id}")
    public CommonResult<Payment> findPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getById(id);
        log.info("========== 查询结果：{}", payment);
        if (payment != null) {
            return new CommonResult<>(200, "查询成功", payment);
        } else {
            return new CommonResult<>(444, "查询失败， i + " + id, null);
        }
    }
}
