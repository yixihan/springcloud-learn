package com.yixihan.springcloud.handle;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.yixihan.springcloud.pojo.CommonResult;
import org.springframework.stereotype.Component;

/**
 * @author : yixihan
 * @create : 2022-01-26-12:35
 */
@Component
public class CustomerBlockHandler {

    public static CommonResult handleException1(BlockException exception) {
        return new CommonResult(2021,"自定义的限流处理信息......CustomerBlockHandler---1");
    }

    public static CommonResult handleException2(BlockException exception) {
        return new CommonResult(2021,"自定义的限流处理信息......CustomerBlockHandler---2");
    }
}
