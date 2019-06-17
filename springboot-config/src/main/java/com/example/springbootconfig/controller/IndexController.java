package com.example.springbootconfig.controller;

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

    //加载配置
    @Value("${boot.a}")
    private String valueA;


    @RequestMapping("/a")
    public String a(){
        System.out.println(valueA);
        return valueA;
    }


    //使用这种方式请非常的注意，启动时会自动执行这个方法，此时b会是配置中的值，但是当你url请求时，b就会是null，它不会把配置映射到参数上了。应用场景非常窄小，不建议采用。
    @Value("${boot.b}")
    @RequestMapping("/b")
    public String b(String b){
        System.out.println(b);
        return b;
    }
}
