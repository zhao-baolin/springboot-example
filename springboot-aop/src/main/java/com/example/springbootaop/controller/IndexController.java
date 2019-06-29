package com.example.springbootaop.controller;

import com.example.springbootaop.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author zhaobaolin
 * @Date 2019/6/27
 */
@RestController
@RequestMapping("/Index")
public class IndexController {

    @Autowired
    private IUserService userService;

    @RequestMapping("/a")
    public String a(){
        return userService.getName();
    }

    @RequestMapping("/b")
    public String b(){
        return userService.getId();
    }

    @RequestMapping("/c")
    public String c(){
        return userService.getSex();
    }

}
