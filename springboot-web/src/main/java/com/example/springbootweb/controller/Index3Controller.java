package com.example.springbootweb.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author zhaobaolin
 * @Date 2019/6/17
 */
@RestController
@RequestMapping("/Index3")
public class Index3Controller {

    //访问：http://localhost:8080/Index3/a?name=小明a
    @RequestMapping("/a")
    public String a(String name){
        System.out.println(name);
        return "输入的参数是："+name;
    }

    //访问：http://localhost:8080/Index3/b/小明b
    @RequestMapping("/b/{name}")
    public String b(@PathVariable("name") String name){
        System.out.println(name);
        return "输入的参数是："+name;
    }

    //也可以这么弄 伪静态  访问：http://localhost:8080/Index3/c.html?name=小明c
    @RequestMapping("/c.html")
    public String c(String name){
        System.out.println(name);
        return "输入的参数是："+name;
    }



}
