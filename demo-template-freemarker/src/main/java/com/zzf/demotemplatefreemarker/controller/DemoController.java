package com.zzf.demotemplatefreemarker.controller;

import com.zzf.demotemplatefreemarker.vo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zzf
 * @date 2021/3/9 10:29 上午
 */
@Controller
public class DemoController {

    @GetMapping
    public ModelAndView demo (HttpServletRequest httpServletRequest,String name){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");

        List<User> userList = new ArrayList<>();
        userList.add(new User("a"));
        userList.add(new User("b"));
        userList.add(new User("c"));

        httpServletRequest.setAttribute("req","val");
        httpServletRequest.getSession().setAttribute("sess","sess");

        modelAndView.addObject("j","k");
        modelAndView.addObject("user",new User("zzf"));
        modelAndView.addObject("userList",userList);
        return modelAndView;
    }
}
