package com.example.springbootthymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author zhaobaolin
 * @Date 2019/6/18
 */
@Controller
@RequestMapping("/Index")
public class IndexController {

    //展示页面
    @RequestMapping("/a")
    public String a(){
        return "a";//对应到a.html
    }

    //赋值
    @RequestMapping("/b")
    public String b(Model model){
        model.addAttribute("name","小明");
        return "b";
    }

    //赋值对象  条件判断
    @RequestMapping("/c")
    public String c(Model model){
        model.addAttribute("user",new User());
        return "c";
    }

    //数据遍历
    @RequestMapping("/d")
    public String d(Model model){
        User user1 = new User("小花",10);
        User user2 = new User("小墙",20);

        List<User> list= new ArrayList<>();
        list.add(user1);
        list.add(user2);

        model.addAttribute("list",list);
        return "d";
    }


    //更多用法请查看官方文档：https://www.thymeleaf.org/doc/tutorials/3.0/usingthymeleaf.html#introducing-thymeleaf

}
