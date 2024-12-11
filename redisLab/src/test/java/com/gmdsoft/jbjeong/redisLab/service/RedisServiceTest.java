package com.gmdsoft.jbjeong.redisLab.service;

import org.junit.jupiter.api.Test;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RedisServiceTest {

    @Autowired
    private RedisService redisService;

    @Test
    public void testSaveFindDelete() {

        String key = "kjkll";
        String value  = "gashaaewqga_g2345_$24g&&34!";

        redisService.save(key, value);
        String read = (String) redisService.find(key);

        assertEquals(value, read);
        LoggerFactory.getLogger(getClass()).info("value : {}", read);

        redisService.delete(key);
        read = (String) redisService.find(key);

        assertNull(read);

        redisService.save("name", "정재봉");
        assertEquals("정재봉", (String)redisService.find("name"));
        redisService.delete("name");

    }

}