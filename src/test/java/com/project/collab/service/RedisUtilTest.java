package com.project.collab.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RedisUtilTest {

    @Autowired
    private RedisUtil redisUtil;

    @Test
    public void redisUtilTest() throws Exception {
        //given
        String email = "test@test.com";
        String code = "123456";

        //when
        redisUtil.setDataExpire(email, code, 60 * 5L);

        //then
        System.out.println(redisUtil.getData("test@test.com"));
        Assertions.assertTrue(redisUtil.existData("test@test.com"));
        Assertions.assertFalse(redisUtil.existData("test1@test.com"));
        Assertions.assertEquals(redisUtil.getData(email), "123456");
    }
}
