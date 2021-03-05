package com.zzf.demoproperties;

import com.zzf.demoproperties.config.Application;
import com.zzf.demoproperties.config.DemoConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoPropertiesApplicationTests {
    @Value("${developer.name}")
    private String name;

    @Autowired
    public DemoConfig demoConfig;

    @Autowired
    public Application application;

    @Test
    void contextLoads() {
        System.out.println(name);
    }

    @Test
    void test(){
        System.out.println(demoConfig);
    }

    @Test
    void prodTest(){
        System.out.println(application);
        System.out.println(name);
    }

}
