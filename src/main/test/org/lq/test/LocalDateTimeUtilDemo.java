package org.lq.test;

import cn.hutool.core.date.LocalDateTimeUtil;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * @author 无语
 * @create 2022-11-18 14:47
 */
public class LocalDateTimeUtilDemo {

    @Test
    public void test(){
        System.out.println("LocalDateTime.now() = " + LocalDateTime.now());
        LocalDateTime offset = LocalDateTimeUtil.offset(LocalDateTime.now(), 600, ChronoUnit.SECONDS);
        System.out.println(offset.toString());
        System.out.println("offset.toLocalDate() = " + offset.toLocalDate());
        System.out.println("offset.toLocalTime() = " + offset.toLocalTime());

    }

}
