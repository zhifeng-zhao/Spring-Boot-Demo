package com.zzf.demohelloworld.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zzf
 * @date 2021/3/3 2:00 上午
 */
@RestController
public class DemoController {
    @GetMapping("/")
    public String helloWord(){
        return "spring hello world";
    }
}
