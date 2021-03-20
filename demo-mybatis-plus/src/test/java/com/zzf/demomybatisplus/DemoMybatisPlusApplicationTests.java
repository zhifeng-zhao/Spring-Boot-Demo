package com.zzf.demomybatisplus;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zzf.demomybatisplus.domain.User;
import com.zzf.demomybatisplus.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DemoMybatisPlusApplicationTests {

    @Autowired
    UserMapper userMapper;

    @Test
    void testQuery() {
        List<User> userList = userMapper.selectList(new QueryWrapper<>());
        System.out.println(userList);
    }

    @Test
    void testQueryByName() {
        User user = new User();
        user.setUsername("zzf");
        List<User> userList = userMapper.selectList(new QueryWrapper<>(user));
        System.out.println(userList);
    }

    @Test
    void testLambdaQuery() {
        List<User> userList = userMapper.selectList(Wrappers
                .<User>lambdaQuery().eq(User::getUsername, "zzf4"));
        System.out.println(userList);
    }

    @Test
    void testPageQuery() {
        IPage<User> userIPage = new Page<>(1, 3);
        IPage<User> page = userMapper.selectPage(userIPage, new QueryWrapper<>());
        System.out.println(page.getRecords());
        System.out.println(page.getTotal());
    }
}
