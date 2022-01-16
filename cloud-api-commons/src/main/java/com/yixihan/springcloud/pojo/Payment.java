package com.yixihan.springcloud.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author : yixihan
 * @create : 2022-01-16-15:18
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment implements Serializable {

    /**
     * id
     */
    private Long id;

    /**
     * 流水号
     */
    private String serial;

}
