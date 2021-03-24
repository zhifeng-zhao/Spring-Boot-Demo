package com.zzf.redis.service;

import com.zzf.redis.domain.User;

/**
 * @author zzf
 * @date 2021/3/24 11:24 下午
 */
public interface UserService {
    /**
     * 获取用户
     * @param id
     * @return
     */
    User get(Long id);

    /**
     * 保存或更新用户
     * @param user
     * @return
     */
    User saveOrUpdate(User user);

    /**
     * 删除用户
     * @param id
     */
    void delete(Long id);
}
