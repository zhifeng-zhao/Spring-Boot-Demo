package com.zzf.demoexceptionhandler.controller;

import com.zzf.demoexceptionhandler.api.ApiResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zzf
 * @date 2021/3/8 10:07 上午
 */
@RestController
public class DemoController {

    @GetMapping
    public ApiResponse response(Integer num) {
        if (num == -1){
            throw new RuntimeException("测试异常");
        }
        return ApiResponse.success("success");
    }
}
