package com.zzf.thymeleaf.controller;

import com.zzf.thymeleaf.vo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author zzf
 * @date 2021/3/11 12:36 上午
 */
@Controller
public class DemoController {

    @GetMapping
    public ModelAndView demo() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");

        modelAndView.addObject("k1","v1");
        modelAndView.addObject(new User(1,"zzf"));

        List<User> userList = new ArrayList<>();
        String[] nameList = {"a","b","c","d","e"};
        for (int i = 0; i < 5;i++) {
            userList.add(new User(i+2,nameList[i]));
        }
        modelAndView.addObject("userList",userList);
        modelAndView.addObject("date",new Date());
        return modelAndView;
    }
}
