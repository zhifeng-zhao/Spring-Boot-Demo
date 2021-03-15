package com.zzf.demojpa;

import com.zzf.demojpa.dao.SysUserDao;
import com.zzf.demojpa.domain.SysUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class DemoJpaApplicationTests {

    @Autowired
    private SysUserDao sysUserDao;

    @Test
    void testInsert() {
        SysUser sysUser = new SysUser();
        sysUser.setUsername("zzf3");
        sysUser.setPassword("1234");
        sysUserDao.save(sysUser);
    }

    @Test
    void testDelete() {
        SysUser user = new SysUser();
        user.setId(3);
        sysUserDao.delete(user);
    }

    @Test
    void testUpdate() {
        Optional<SysUser> optional = sysUserDao.findById(2);
        SysUser sysUser = optional.get();
        sysUser.setPassword("newPwd");
        sysUserDao.save(sysUser);
    }

    @Test
    void testQuery() {
        Iterable<SysUser> all = sysUserDao.findAll();
        System.out.println(all);

        SysUser user = sysUserDao.findByUsername("zzf");
        System.out.println(user);
    }

}
