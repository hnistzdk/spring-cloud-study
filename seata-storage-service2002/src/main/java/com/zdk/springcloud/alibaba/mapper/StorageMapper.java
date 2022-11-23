package com.zdk.springcloud.alibaba.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zdk.springcloud.alibaba.domain.Storage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Description
 * @Author zdk
 * @Date 2022/11/23 18:25
 */
@Mapper
public interface StorageMapper extends BaseMapper<Storage> {
    /**
     * 扣减库存
     * @param productId
     * @param count
     */
    void decrease(@Param("productId") Long productId, @Param("count") Integer count);
}
