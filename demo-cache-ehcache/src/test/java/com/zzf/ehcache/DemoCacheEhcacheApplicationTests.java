package com.zzf.ehcache;

import com.zzf.ehcache.domain.User;
import com.zzf.ehcache.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class DemoCacheEhcacheApplicationTests {

    @Autowired
    private UserService userService;

    /**
     * 查询两次
     */
    @Test
    void test() {
        User user1 = userService.get(1L);
        log.debug("【user1】= {}", user1);

        // 再次查询,只打印一次证明缓存生效
        User user2 = userService.get(1L);
        log.debug("【user2】= {}", user2);
    }

    /**
     * 先保存后查询
     */
    @Test
    void getAfterSave() {
        userService.updateOrSave(new User(4L, "user4"));
        User user = userService.get(4L);
        log.debug("user4:" + user);
    }

    /**
     * 测试删除
     */
    @Test
    void delete() {
        userService.get(1L);
        userService.delete(1L);
        User user = userService.get(1L);
        log.debug("user1:" + user);
    }
}
