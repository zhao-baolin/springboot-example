package com.example.springbootwebsocket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description
 * @Author zhaobaolin
 * @Date 2019/6/30
 */
@Controller
@RequestMapping("/Index")
public class IndexController {

    // 同时打开三个页面 广播式推送
    // http://localhost:8080/Index/index_a
    // http://localhost:8080/Index/index_b
    // http://localhost:8080/Index/index_c
    @RequestMapping("/index_a")
    public String indexa(){
        return "indexa";
    }

    @RequestMapping("/index_b")
    public String indexb(){
        return "indexb";
    }

    @RequestMapping("/index_c")
    public String indexc(){
        return "indexc";
    }




}
