package com.example.springbootlanguage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description
 * @Author zhaobaolin
 * @Date 2019/6/18
 */
@Controller
@RequestMapping("/Index")
public class IndexController {

    @RequestMapping("/a")
    public String a(){
        return "/a";
    }

}
