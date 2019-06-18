package com.example.springbootinterceptor.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author zhaobaolin
 * @Date 2019/6/18
 */
@RestController
@RequestMapping("/Index")
public class IndexController {

    @RequestMapping("/a")
    public String a(){
        return "a";
    }

    @RequestMapping("/b")
    public String b(){
        return "b";
    }

    @RequestMapping("/c")
    public String c(){
        return "c";
    }
}
