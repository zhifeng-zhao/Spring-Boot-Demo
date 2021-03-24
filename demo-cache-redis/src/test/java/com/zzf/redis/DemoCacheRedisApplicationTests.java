package com.zzf.redis;

import com.zzf.redis.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.io.Serializable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

@SpringBootTest
@Slf4j
class DemoCacheRedisApplicationTests {
    @Autowired
    private RedisTemplate<String, Serializable> redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * redis测试
     */
    @Test
    void redisTest() {
        // 测试线程安全，程序结束查看redis中count的值是否为1000
        ExecutorService service = Executors.newFixedThreadPool(1000);
        IntStream.range(0, 1000).forEach(i -> service.execute(()
                                            -> stringRedisTemplate.opsForValue()
                                                                    .increment("count", 1)));

        stringRedisTemplate.opsForValue().set("k1", "v1");
        String k1 = stringRedisTemplate.opsForValue().get("k1");
        log.info("K1 = " + k1);

        String key = "user:zzf:1";
        redisTemplate.opsForValue().set(key, new User(1L, "zzf1"));
        // 对应 String（字符串）
        User user = (User) redisTemplate.opsForValue().get(key);
        log.debug("【user】= {}", user);
    }

}
