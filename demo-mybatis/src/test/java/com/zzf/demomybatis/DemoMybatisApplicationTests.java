package com.zzf.demomybatis;

import com.zzf.demomybatis.dao.TUserDao;
import com.zzf.demomybatis.domain.SysUser;
import com.zzf.demomybatis.entity.TUser;
import com.zzf.demomybatis.mapper.SysUserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DemoMybatisApplicationTests {
    @Autowired
    private SysUserMapper userMapper;

    @Autowired
    private TUserDao tUserDao;

    @Test
    void contextLoads() {
        System.out.println(userMapper.queryAll());
    }

    @Test
    void testSave() {
        SysUser user = new SysUser();
        user.setUsername("zzf5");
        user.setPassword("123456");
        userMapper.saveSysUser(user);
        System.out.println(user.getId());
    }

    @Test
    void testQueryAll() {
        List<TUser> tUsers = tUserDao.queryAll(new TUser());
        System.out.println(tUsers);
    }

}
