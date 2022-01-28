package com.yixihan.springcloud.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author : yixihan
 * @create : 2022-01-28-13:15
 */
@Mapper
public interface StorageMapper {

    /**
     * 扣减库存
     */
    void decrease(@Param("productId") Long productId, @Param("count") Integer count);

}
