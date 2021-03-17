package com.zzf.demomybatismapperpage;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zzf.demomybatismapperpage.domain.TUser;
import com.zzf.demomybatismapperpage.mapper.TUserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DemoMybatisMapperPageApplicationTests {

    @Autowired
    TUserMapper userMapper;

    @Test
    void selectAll() {
        System.out.println(userMapper.selectAll());
    }

    @Test
    void insertUser() {
        TUser user = new TUser();
        user.setUsername("zzf7");
        user.setPassword("123");
        System.out.println(userMapper.insert(user));
        System.out.println(user.getId());
    }

    @Test
    void testQuery() {
        TUser user = new TUser();
        user.setPassword("123");
        List<TUser> userList = userMapper.select(user);
        System.out.println(userList);
    }

    @Test
    void testPage() {
        PageHelper.startPage(1,4);
        List<TUser> userList = userMapper.selectAll();
        PageInfo<TUser> info = new PageInfo<>(userList);
        System.out.println(info);
    }

}
