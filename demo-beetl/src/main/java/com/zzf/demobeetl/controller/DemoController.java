package com.zzf.demobeetl.controller;

import com.zzf.demobeetl.vo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author zzf
 * @date 2021/3/12 8:49 下午
 */
@Controller
public class DemoController {

    @GetMapping
    public ModelAndView demo() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index.btl");

        modelAndView.addObject("value","zzf");

        List<User> userList = new ArrayList<>();
        String[] nameList = {"a","b","c","d","e"};
        for (int i = 0; i < 5; i++) {
            userList.add(new User(nameList[i]));
        }
        modelAndView.addObject("userList",userList);
        modelAndView.addObject("date",new Date());
        return modelAndView;
    }
}
