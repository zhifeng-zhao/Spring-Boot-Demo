package com.zzf.demojpa.dao;

import com.zzf.demojpa.domain.SysUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author zzf
 * @date 2021/3/15 3:50 下午
 */
@Repository
public interface SysUserDao extends CrudRepository<SysUser, Integer> {
    /**
     * 根据用户名查找用户
     * @param name
     * @return
     */
    public SysUser findByUsername(String name);
}

