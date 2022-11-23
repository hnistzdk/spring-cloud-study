package com.zdk.springcloud.alibaba.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zdk.springcloud.alibaba.domain.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 * @Description
 * @Author zdk
 * @Date 2022/11/23 16:52
 */
@Mapper
public interface AccountMapper extends BaseMapper<Account> {
    /**
     * 扣减账户余额
     * @param userId
     * @param money
     */
    void decrease(@Param("userId") Long userId, @Param("money") BigDecimal money);

}
