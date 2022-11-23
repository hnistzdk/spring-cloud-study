package com.zdk.springcloud.alibaba.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zdk.springcloud.alibaba.domain.Order;

/**
 * @Description
 * @Author zdk
 * @Date 2022/11/23 17:02
 */
public interface OrderService extends IService<Order> {
    /**
     * 新建订单
     * @param order
     */
    void create(Order order);
}
