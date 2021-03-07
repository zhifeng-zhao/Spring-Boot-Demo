package com.zzf.logaop.controller;

import com.zzf.logaop.config.DemoLog;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zzf
 * @date 2021/3/7 11:24 下午
 */

@RestController
public class DemoController {

    @DemoLog("拦截测试")
    @GetMapping
    public String hello(String username) {
        return "hello " + username;
    }
}
