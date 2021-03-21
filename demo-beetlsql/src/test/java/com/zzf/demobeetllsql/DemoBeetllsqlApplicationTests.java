package com.zzf.demobeetllsql;

import com.zzf.demobeetllsql.dao.UserDao;
import com.zzf.demobeetllsql.domian.User;
import org.beetl.sql.core.engine.PageQuery;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DemoBeetllsqlApplicationTests {

    @Autowired
    UserDao userDao;

    @Test
    void testQuery() {
        System.out.println(userDao.all());
    }

    @Test
    void testInsert() {
        User user = new User();
        user.setUsername("zzf");
        user.setPassword("beetlsql");
        userDao.insert(user);
        System.out.println(userDao.all());
    }

    @Test
    void testQueryByName() {
        System.out.println(userDao.selectByUsername("zzf"));
    }

    @Test
    void testPageQuery() {
        PageQuery<User> pageQuery = userDao.createLambdaQuery().page(1, 5);
        List<User> userList = pageQuery.getList();
        System.out.println(userList);
    }

}
