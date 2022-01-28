package com.yixihan.springcloud.mapper;

import com.yixihan.springcloud.pojo.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author : yixihan
 * @create : 2022-01-28-11:59
 */
@Mapper
public interface OrderMapper {

    /**
     * 创建订单
     */
    void create(Order order);

    /**
     * 修改订单金额
     */
    void update(@Param("userId") Long userId, @Param("status") Integer status);

}
