package com.yixihan.springcloud.service.fallback;

import com.yixihan.springcloud.pojo.CommonResult;
import com.yixihan.springcloud.service.StorageService;
import org.springframework.stereotype.Component;

/**
 * @author : yixihan
 * @create : 2022-01-28-12:25
 */
@Component
public class StorageServiceFallback implements StorageService {

    @Override
    public CommonResult decrease(Long productId, Integer count) {
        return new CommonResult (4444, "服务器繁忙, 请稍后再试");
    }
}
