package com.zdk.springcloud.alibaba.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zdk.springcloud.alibaba.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Description
 * @Author zdk
 * @Date 2022/11/23 16:52
 */
@Mapper
public interface OrderMapper extends BaseMapper<Order> {

    /**
     * 修改订单状态
     * @param orderId
     * @param status
     */
    void update(@Param("orderId") Long orderId,@Param("status") Integer status);

}
