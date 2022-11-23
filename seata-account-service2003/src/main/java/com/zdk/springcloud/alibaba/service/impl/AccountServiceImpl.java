package com.zdk.springcloud.alibaba.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zdk.springcloud.alibaba.domain.Account;
import com.zdk.springcloud.alibaba.mapper.AccountMapper;
import com.zdk.springcloud.alibaba.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

/**
 * @Description
 * @Author zdk
 * @Date 2022/11/23 17:02
 */
@Service
@Slf4j
public class AccountServiceImpl extends ServiceImpl<AccountMapper,Account> implements AccountService {
    /**
     * 扣减账户余额
     */
    @Override
    public void decrease(Long userId, BigDecimal money) {
        log.info("------->account-service中扣减账户余额start");
        //模拟超时异常，全局事务回滚
        try {
            TimeUnit.SECONDS.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.baseMapper.decrease(userId, money);
        log.info("------->account-service中扣减账户余额end");
    }
}
