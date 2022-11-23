package com.zdk.springcloud.alibaba.controller;

import com.zdk.springcloud.alibaba.service.AccountService;
import com.zdk.springcloud.alibaba.domain.CommonResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @Description
 * @Author zdk
 * @Date 2022/11/23 17:25
 */
@RestController
public class AccountController {

    @Resource
    private AccountService accountService;


    @PostMapping("/account/decrease")
    public CommonResult decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money) {
        accountService.decrease(userId, money);
        return new CommonResult(200, "扣减账户余额成功！");
    }

}
