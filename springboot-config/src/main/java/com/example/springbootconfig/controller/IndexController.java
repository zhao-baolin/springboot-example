package com.example.springbootconfig.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author zhaobaolin
 * @Date 2019/6/17
 */
@RestController
@RequestMapping("/Index")
public class IndexController {

    //读取配置
    @Value("${boot.a}")
    private String valueA;

    //如果配置没有就给个默认值
    @Value("${boot.h:替代者}")
    private String valueH;

    @Autowired
    private Entity entity;

    //访问：http://localhost:8888/Index/a
    @RequestMapping("/a")
    public String a(){
        System.out.println(valueA);
        return valueA;
    }

    //访问：http://localhost:8888/Index/h
    @RequestMapping("/h")
    public String h(){
        System.out.println(valueH);
        return valueH;
    }


    //读取配置到方法参数上
    //访问：http://localhost:8888/Index/b
    @RequestMapping("/b")
    public String b(@Value("${boot.b}") String valueB){
        System.out.println(valueB);
        return valueB;
    }

    @RequestMapping("/c")
    public String c(){
        System.out.println(entity.toString());
        return entity.toString();
    }


    //这种玩法就别用了，启动时就会自动跑一遍这个方法，此时b会是配置中的值，但是当你url请求时，b就会是null，它不会把配置映射到参数上了。
    @Value("${boot.b}")
    @RequestMapping("/r")
    public String r(String str){
        System.out.println(str);
        return str;
    }


}
