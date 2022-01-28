package com.yixihan.springcloud.service;

import com.yixihan.springcloud.pojo.CommonResult;
import com.yixihan.springcloud.service.fallback.AccountServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @author : yixihan
 * @create : 2022-01-28-12:13
 */
@FeignClient(value = "seata-account-service", fallback = AccountServiceFallback.class)
public interface AccountService {

    /**
     * 扣减账户
     */
    @PostMapping(value = "/account/decrease")
    CommonResult decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money);
}
