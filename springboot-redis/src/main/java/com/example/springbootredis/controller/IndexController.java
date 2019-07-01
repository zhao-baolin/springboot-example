package com.example.springbootredis.controller;

import com.example.springbootredis.redis.RedisUtil;
import com.example.springbootredis.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author zhaobaolin
 * @Date 2019/7/1
 */
@RestController
@RequestMapping("/Index")
public class IndexController {

    @Autowired
    private RedisUtil redisUtil;

    //访问：http://localhost:8080/Index/a?name=毛线
    @RequestMapping("/a")
    public String a(String name){
        redisUtil.set("name",name);
        return "保存成功";
    }

    //访问：http://localhost:8080/Index/b
    @RequestMapping("/b")
    public String b(){
        String name = redisUtil.get("name");
        return name;
    }


    //访问：http://localhost:8080/Index/c
    @RequestMapping("/c")
    public String c(){
        User user = new User();
        user.setId(1L);
        user.setName("张三");
        user.setSex("男");
        redisUtil.setObj("user",user);
        return "保存成功";
    }


    //访问：http://localhost:8080/Index/d
    @RequestMapping("/d")
    public String d(){
        User user = redisUtil.getObj("user",User.class);
        return user == null ? "无" : user.toString();
    }



    //访问：http://localhost:8080/Index/send
    @RequestMapping("/send")
    public String send(){
        redisUtil.sendMsg("a133","小姐姐你在哪");
        return "发布成功";
    }


}
