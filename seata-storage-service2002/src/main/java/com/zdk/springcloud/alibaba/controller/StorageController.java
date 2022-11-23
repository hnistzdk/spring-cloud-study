package com.zdk.springcloud.alibaba.controller;

import com.zdk.springcloud.alibaba.domain.CommonResult;
import com.zdk.springcloud.alibaba.service.StorageService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description
 * @Author zdk
 * @Date 2022/11/23 18:43
 */
@RestController
public class StorageController {
    @Resource
    private StorageService storageService;

    /**
     * 扣减库存
     */
    @PostMapping("/storage/decrease")
    public CommonResult decrease(Long productId, Integer count) {
        storageService.decrease(productId, count);
        return new CommonResult(200, "扣减库存成功！");
    }
}
