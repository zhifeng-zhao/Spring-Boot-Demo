package com.zzf.ehcache.service;

import com.zzf.ehcache.domain.User;

/**
 * @author zzf
 * @date 2021/4/2 10:31 下午
 */
public interface UserService {

    /**
     * 获取用户
     * @param id
     * @return User
     */
    User get(Long id);

    /**
     * 删除用户
     * @param id
     */
    void delete(Long id);

    /**
     * 保存或修改用户
     * @param user
     * @return
     */
    User updateOrSave(User user);

}
