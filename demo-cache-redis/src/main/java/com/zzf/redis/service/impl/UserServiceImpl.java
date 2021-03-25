package com.zzf.redis.service.impl;

import com.google.common.collect.Maps;
import com.zzf.redis.domain.User;
import com.zzf.redis.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author zzf
 * @date 2021/3/24 11:27 下午
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {
    /**
     * 模拟数据库
     */
    private static final Map<Long, User> DATEBASES = Maps.newConcurrentMap();

    /**
     * 初始化数据
     */
    static {
        DATEBASES.put(1L, new User(1L, "zzf1"));
        DATEBASES.put(2L, new User(2L, "zzf2"));
        DATEBASES.put(3L, new User(3L, "zzf3"));
    }

    /**
     * cacheNames/value ：用来指定缓存组件的名字
     *
     * key ：缓存数据时使用的 key，可以用它来指定。默认是使用方法参数的值。（这个 key 你可以使用 spEL 表达式来编写）
     *
     * keyGenerator ：key 的生成器。 key 和 keyGenerator 二选一使用
     *
     * cacheManager ：可以用来指定缓存管理器。从哪个缓存管理器里面获取缓存。
     *
     * condition ：可以用来指定符合条件的情况下才缓存
     *
     * unless ：否定缓存。当 unless 指定的条件为 true ，方法的返回值就不会被缓存。当然你也可以获取到结果进行判断。（通过 #result 获取方法结果）
     *
     * sync ：是否使用异步模式。
     * @param id
     * @return
     */
    @Cacheable(value = "user", key = "#id")
    @Override
    public User get(Long id) {
        log.info("查询用户id=" + id);
        return DATEBASES.get(id);
    }

    @Cacheable(value = "user", key = "#user.id")
    @Override
    public User saveOrUpdate(User user) {
        DATEBASES.put(user.getId(), user);
        log.info("保存用户id=" + user.getId());
        return user;
    }

    @Cacheable(value = "user", key = "#id")
    @CacheEvict(value = "user", allEntries = true)   // 清楚所有缓存
    @Override
    public void delete(Long id) {
        DATEBASES.remove(id);
        log.info("删除用户id=" + id);
    }
}
