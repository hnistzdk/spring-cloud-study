package com.zdk.springcloud.alibaba.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zdk.springcloud.alibaba.domain.Storage;


/**
 * @Description
 * @Author zdk
 * @Date 2022/11/23 17:12
 */
public interface StorageService extends IService<Storage> {

    /**
     * 扣减库存
     * @param productId
     * @param count
     */
    void decrease(Long productId, Integer count);

}
