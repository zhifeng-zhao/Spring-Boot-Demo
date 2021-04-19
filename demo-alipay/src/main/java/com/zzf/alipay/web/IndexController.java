package com.zzf.alipay.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author zzf
 * @date 2021/4/19 11:53 下午
 */
@Controller
public class IndexController {

    @GetMapping("/index")
    public String index() {
        return "index";
    }
}
