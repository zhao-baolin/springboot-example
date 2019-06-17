package com.example.springbootweb.controller;

import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

/**
 * @Description
 * @Author zhaobaolin
 * @Date 2019/6/17
 */
@RestController
@RequestMapping("/Index3")
public class Index3Controller {

    //自动获取参数 将url上的参数对应到方法的入参上 要求参数名称完全一致
    //访问：http://localhost:8080/Index3/a?name=小明a
    @RequestMapping("/a")
    public String a(String name){
        System.out.println(name);
        return "输入的参数是："+name;
    }

    //如果url上的参数和方法的入参名字不相同呢？ 比如url上的参数名是user_name，方法入参是userName，这种情况可以使用如下@RequestParam注解
    //访问：http://localhost:8080/Index3/aa?user_name=小明aa
    //如果访问：http://localhost:8080/Index3/aa 会报错 因为没有捕获到user_name参数
    @RequestMapping("/aa")
    public String aa(@RequestParam("user_name") String userName){
        System.out.println(userName);
        return "输入的参数是："+userName;
    }

    //使用@RequestParam注解要求必须传递该参数 否则会报错 这里我们可以使用@RequestParam注解的另一个required选项，使该参数可以不传 注意措辞是不传 而不是传空
    //访问：http://localhost:8080/Index3/aaa
    @RequestMapping("/aaa")
    public String aaa(@RequestParam(value = "user_name",required = false) String userName){
        System.out.println(userName);
        return "输入的参数是："+userName;
    }

    //如果我希望没有该参数的时候给个默认值呢？ 可以使用@RequestParam注解的另一个defaultValue选项指定默认值 这个默认值在该参数不传或者传空时都会发动
    //访问：http://localhost:8080/Index3/aaaa 或 http://localhost:8080/Index3/aaaa?user_name=
    @RequestMapping("/aaaa")
    public String aaaa(@RequestParam(value = "user_name",required = false,defaultValue = "无名氏") String userName){
        System.out.println(userName);
        return "输入的参数是："+userName;
    }


    //简化方式
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


    //传递数组参数 参数数组内容以逗号分割即可
    //访问：http://localhost:8080/Index3/requestArray?ids=3,5,6,22
    @RequestMapping("/requestArray")
    public String requestArray(int[] ids){
        System.out.println(Arrays.toString(ids));
        return "输入的参数是："+Arrays.toString(ids);
    }




    //传递实体对象 入参必须是json格式，使用@RequestBody注解将参数映射到实体中的属性上 spring会自动调用实体中的set方法进行赋值
    //注意：这里有大坑，只有post、put方法才会有request body，所以如果使用get方法是取不到东西的,最好是直接写成@PostMapping。
    //访问：http://localhost:8080/Index3/requestBody  参数：{"name":"aaaa","sex":3}  方式：post 请求头：Content-Type=application/json
    @RequestMapping("/requestBody")
    public String requestBody(@RequestBody User user){
        System.out.println(user.toString());
        return "输入的参数是："+user.toString();
    }

    //传递实体对象 便捷方式 不使用@RequestBody 就使用自动映射
    //访问：http://localhost:8080/Index3/requestBody2?name=ff&sex=3
    @RequestMapping("/requestBody2")
    public String requestBody2(User user){
        System.out.println(user.toString());
        return "输入的参数是："+user.toString();
    }


}
