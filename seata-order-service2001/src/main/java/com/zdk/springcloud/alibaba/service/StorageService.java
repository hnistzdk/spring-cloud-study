package com.zdk.springcloud.alibaba.service;

import com.zdk.springcloud.alibaba.domain.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Description
 * @Author zdk
 * @Date 2022/11/23 17:12
 */
@FeignClient(value = "seata-storage-service")
public interface StorageService {

    /**
     * 减库存
     * @param productId
     * @param count
     * @return
     */
    @PostMapping(value = "/storage/decrease")
    CommonResult decrease(@RequestParam("productId") Long productId,@RequestParam("count") Integer count);

}
