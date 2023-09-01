package com.icss;

import com.icss.pojo.Cabinet;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

@SpringBootTest
class ServiceConsumerApplicationTests {

    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
//    private RedisTemplate<String,String> stringRedisTemplate;
    private StringRedisTemplate stringRedisTemplate;
    @Test
    void contextLoads() {
        ValueOperations<String, String> valueOperations = stringRedisTemplate.opsForValue();
        valueOperations.set("password","123456");
        System.out.println(valueOperations.get("password"));
    }

}
