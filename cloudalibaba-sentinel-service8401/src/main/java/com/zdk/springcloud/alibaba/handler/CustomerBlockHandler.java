package com.zdk.springcloud.alibaba.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.zdk.springcloud.entities.CommonResult;

/**
 * @Description
 * @Author zdk
 * @Date 2022/11/21 17:55
 */
public class CustomerBlockHandler {
    public static CommonResult handleException(BlockException exception){
        return new CommonResult(444, "按客户自定义,global handleException----1");
    }

    public static CommonResult handleException2(BlockException exception){
        return new CommonResult(444, "按客户自定义,global handleException----2");
    }
}
