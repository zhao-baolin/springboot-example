package com.example.springbootweb.controller;

import org.springframework.web.bind.annotation.*;

/**
 * @Description
 * @Author zhaobaolin
 * @Date 2019/6/12
 */
@RestController //@Controller 和 @ResponseBody的结合  代表当前类申明成控制器bean，并且当前类中的所有方法都是直接返回数据，而不是渲染页面。
@RequestMapping("/Index") //当前控制器可以接受任意请求  get、put、post、delete等
public class IndexController {


    //当前方法只能get请求 返回数组数据
    @GetMapping("/a")
    public int[] a(){
        int[] arr = new int[3];
        arr[0] = 10;
        arr[1] = 11;
        arr[2] = 12;
        return arr;
    }

    //当前方法只能post请求 返回字符串
    @PostMapping("/b")
    public String b(){
        return "你好，这是b方法";
    }

    //当前方法允许任意请求 返回字符串
    @RequestMapping("/c")
    public String c(){
        return "你好，这是c方法";
    }
}
