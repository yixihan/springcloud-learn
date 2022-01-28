package com.yixihan.springcloud.service.fallback;

import com.yixihan.springcloud.pojo.CommonResult;
import com.yixihan.springcloud.service.AccountService;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * @author : yixihan
 * @create : 2022-01-28-12:34
 */
@Component
public class AccountServiceFallback implements AccountService {

    @Override
    public CommonResult decrease(Long userId, BigDecimal count) {
        return new CommonResult (4444, "服务器繁忙, 请稍后再试");
    }
}
