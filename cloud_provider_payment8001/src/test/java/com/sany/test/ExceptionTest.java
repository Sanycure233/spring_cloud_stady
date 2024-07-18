package com.sany.test;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 为了测试异常拦截器的方法
 *
 * @author: SanyQAQ
 * @create: 2024-07-17-21:05
 */
@SpringBootTest
public class ExceptionTest {
    @Test
    public void f1(){
        throw new RuntimeException("f1抛出的异常");
    }
}
