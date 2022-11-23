package com.zdk.springcloud.alibaba.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zdk.springcloud.alibaba.domain.Order;
import com.zdk.springcloud.alibaba.mapper.OrderMapper;
import com.zdk.springcloud.alibaba.service.AccountService;
import com.zdk.springcloud.alibaba.service.OrderService;
import com.zdk.springcloud.alibaba.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Description
 * @Author zdk
 * @Date 2022/11/23 17:02
 */
@Service
@Slf4j
public class OrderServiceImpl extends ServiceImpl<OrderMapper,Order> implements OrderService {

    @Resource
    private AccountService accountService;

    @Resource
    private StorageService storageService;


    @GlobalTransactional(name = "my_seata", rollbackFor = Exception.class)
    @Override
    public void create(Order order) {
        log.info("-----> 新建订单start");
        this.baseMapper.insert(order);
        log.info("-----> 新建订单end");

        log.info("-----> 订单微服务调用库存微服务 扣减库存start");
        storageService.decrease(order.getProductId(), order.getCount());
        log.info("-----> 订单微服务调用库存微服务 扣减库存end");

        log.info("-----> 订单微服务调用账户微服务 扣除余额start");
        accountService.decrease(order.getUserId(), order.getMoney());
        log.info("-----> 订单微服务调用账户微服务 扣除余额end");

        //修改订单状态 从0到1
        log.info("-----> 修改订单状态start");
        this.baseMapper.update(order.getId(), order.getStatus());
        log.info("-----> 修改订单状态end");

    }
}
