package com.zzf.redis;

import com.zzf.redis.domain.User;
import com.zzf.redis.service.UserService;
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

    @Autowired
    private UserService userService;

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

        /**
         * opsForValue：对应 String（字符串）
         * opsForZSet：对应 ZSet（有序集合）
         * opsForHash：对应 Hash（哈希）
         * opsForList：对应 List（列表）
         * opsForSet：对应 Set（集合）
         * opsForGeo：** 对应 GEO（地理位置）
         */
        stringRedisTemplate.opsForValue().set("k1", "v1");
        String k1 = stringRedisTemplate.opsForValue().get("k1");
        log.info("K1 = " + k1);

        String key = "user:zzf:1";
        redisTemplate.opsForValue().set(key, new User(1L, "zzf1"));
        // 对应 String（字符串）
        User user = (User) redisTemplate.opsForValue().get(key);
        log.debug("【user】= {}" + user);
    }

    /**
     * 缓存测试
     */
    @Test
    void cacheTest() {
        // 获取两次，查看日志验证缓存
        User user1 = userService.get(1L);
        log.debug("user1 = " + user1);
        User user2 = userService.get(1L);
        log.debug("user2 = " + user2);

        // 先存再查，查看日志验证缓存
        userService.saveOrUpdate(new User(4L, "测试"));
        User user4 = userService.get(4L);
        log.debug("user4 = " + user4);

        // 测试删除，查看redis是否存在缓存数据
        // 查询一次，使redis中存在缓存数据
        userService.get(1L);
        // 删除，查看redis是否存在缓存数据
        userService.delete(1L);
    }

}
