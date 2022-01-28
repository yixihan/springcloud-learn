package com.yixihan.springcloud.service;

import com.yixihan.springcloud.pojo.CommonResult;
import com.yixihan.springcloud.service.fallback.StorageServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author : yixihan
 * @create : 2022-01-28-12:13
 */
@FeignClient(value = "seata-storage-service", fallback = StorageServiceFallback.class)
public interface StorageService {

    /**
     * 扣减库存
     */
    @PostMapping(value = "/storage/decrease")
    CommonResult decrease(@RequestParam("productId") Long productId, @RequestParam("count") Integer count);
}
