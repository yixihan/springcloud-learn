package com.yixihan.springcloud.service;

import com.yixihan.springcloud.pojo.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author : yixihan
 * @create : 2022-01-16-15:37
 */
public interface PaymentService {

    /**
     * 创建一个订单对象
     * @param payment 订单对象
     * @return 订单对象
     */
    Integer create (Payment payment);


    /**
     * 根据 id 获取订单对象
     * @param id 订单 id
     * @return 订单对象
     */
    Payment getPaymentById (@Param("id") Long id);


}
