package com.zzf.ehcache.service.impl;

import com.google.common.collect.Maps;
import com.zzf.ehcache.domain.User;
import com.zzf.ehcache.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author zzf
 * @date 2021/4/2 10:31 下午
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private static final Map<Long, User> DATABASES = Maps.newConcurrentMap();

    static {
        DATABASES.put(1L, new User(1L, "User1"));
        DATABASES.put(2L, new User(2L, "User2"));
        DATABASES.put(3L, new User(3L, "User3"));
    }

    @Cacheable(value = "user", key = "#id")
    @Override
    public User get(Long id) {
        log.info("查询用户id:" + id);
        return DATABASES.get(id);
    }

    @CacheEvict(value = "user",key = "#id")
    @Override
    public void delete(Long id) {
        DATABASES.remove(id);
        log.info("删除用户id：" + id);
    }

    @CachePut(value = "user",key = "#user.id")
    @Override
    public User updateOrSave(User user) {
        DATABASES.put(user.getId(),user);
        log.info("保存用户:" + user);
        return user;
    }
}
