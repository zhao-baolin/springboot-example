package com.example.springbootweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @Description
 * @Author zhaobaolin
 * @Date 2019/6/12
 */
@Controller //当前类申明成控制器bean  没有@ResponseBody的话那么当前控制器的方法返回默认渲染页面
public class Index2Controller {

    //报错 因为没有返回数据对应的这个页面
    @GetMapping("/Index2/a")
    public int[] a(){
        int[] arr = new int[3];
        arr[0] = 10;
        arr[1] = 11;
        arr[2] = 12;
        return arr;
    }

    //报错 因为没有返回数据对应的这个页面
    @PostMapping("/Index2/b")
    public String b(){
        return "你好，这是 Index2的 b方法";
    }

    //返回 "你好，这是 Index2的 c方法" 因为加了@ResponseBody代表直接返回数据 而不是渲染页面
    @ResponseBody
    @RequestMapping("/Index2/c")
    public String c(){
        return "你好，这是 Index2的 c方法";
    }
}
