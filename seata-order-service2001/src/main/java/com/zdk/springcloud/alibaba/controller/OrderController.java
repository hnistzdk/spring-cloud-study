package com.zdk.springcloud.alibaba.controller;

import com.zdk.springcloud.alibaba.domain.CommonResult;
import com.zdk.springcloud.alibaba.domain.Order;
import com.zdk.springcloud.alibaba.service.OrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description
 * @Author zdk
 * @Date 2022/11/23 17:25
 */
@RestController
public class OrderController {

    @Resource
    private OrderService orderService;

    @PostMapping("/order/create")
    public CommonResult create(@RequestBody Order order){
        orderService.create(order);
        return new CommonResult(200, "订单创建成功");
    }

}
