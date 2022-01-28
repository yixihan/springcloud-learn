package com.yixihan.springcloud.service.impl;

import com.yixihan.springcloud.mapper.StorageMapper;
import com.yixihan.springcloud.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author : yixihan
 * @create : 2022-01-28-13:21
 */
@Service
@Slf4j
public class StorageServiceImpl implements StorageService {

    private static final Logger LOGGER = LoggerFactory.getLogger (StorageServiceImpl.class);

    @Resource
    private StorageMapper storageMapper;

    @Override
    public void decrease(Long productId, Integer count) {
        LOGGER.info ("------->storage-service中扣减库存开始");
        storageMapper.decrease (productId, count);
        LOGGER.info ("------->storage-service中扣减库存结束");

    }
}
