package com.yixihan.springcloud;

import org.junit.Test;

import java.time.ZonedDateTime;

/**
 * @author : yixihan
 * @create : 2022-01-20-7:24
 */
public class TimeTest {

    @Test
    public void test1 () {
        ZonedDateTime zdt = ZonedDateTime.now();
        System.out.println (zdt);
    }
}
