package com.zdk.springcloud.alibaba.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zdk.springcloud.alibaba.domain.Storage;
import com.zdk.springcloud.alibaba.mapper.StorageMapper;
import com.zdk.springcloud.alibaba.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


/**
 * @Description
 * @Author zdk
 * @Date 2022/11/23 17:02
 */
@Service
@Slf4j
public class StorageServiceImpl extends ServiceImpl<StorageMapper, Storage> implements StorageService {
    /**
     * 扣减库存
     */
    @Override
    public void decrease(Long productId, Integer count) {
        log.info("------->storage-service中扣减库存start");
        this.baseMapper.decrease(productId, count);
        log.info("------->storage-service中扣减库存end");
    }
}
