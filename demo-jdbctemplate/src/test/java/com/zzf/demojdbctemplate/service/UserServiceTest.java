package com.zzf.demojdbctemplate.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


/**
 * @author zzf
 * @date 2021/3/14 3:22 上午
 */
@SpringBootTest
class UserServiceTest {
    @Autowired
    UserService userService;

    @Test
    void insert() {
        userService.insert("zzf", "1234");
    }

    @Test
    void delete() {
        userService.delete(1);
    }

    @Test
    void update() {
        userService.update(2, "123");
    }

    @Test
    void query() {
        System.out.println(userService.query(2));
    }
}