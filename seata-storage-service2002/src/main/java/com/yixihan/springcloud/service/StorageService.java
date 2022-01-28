package com.yixihan.springcloud.service;

/**
 * @author : yixihan
 * @create : 2022-01-28-13:21
 */
public interface StorageService {
    /**
     * 扣减库存
     */
    void decrease(Long productId, Integer count);
}
