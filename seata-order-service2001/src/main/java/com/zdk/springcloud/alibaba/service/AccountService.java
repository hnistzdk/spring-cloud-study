package com.zdk.springcloud.alibaba.service;

import com.zdk.springcloud.alibaba.domain.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @Description
 * @Author zdk
 * @Date 2022/11/23 17:14
 */
@FeignClient(value = "seata-account-service")
public interface AccountService {

    /**
     * 减账户余额
     * @param userId
     * @param money
     * @return
     */
    @PostMapping(value = "/account/decrease")
    CommonResult decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money);
}
