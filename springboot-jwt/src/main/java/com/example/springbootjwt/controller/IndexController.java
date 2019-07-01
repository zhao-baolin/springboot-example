package com.example.springbootjwt.controller;

import com.example.springbootjwt.entity.User;
import com.example.springbootjwt.system.JWT;
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

    @RequestMapping("/encode")
    public String encode(){
        User user = new User();
        user.setId(1L);
        user.setName("小明");
        user.setSex("男");

        String token = JWT.encode(user,60 * 1000);
        System.out.println("生成的token是："+token);
        return "生成的token是："+token;
    }

    @RequestMapping("/decode")
    public String decode(String token){
        if(null == token){
            return "请输入token";
        }
        User user = JWT.decode(token,User.class);
        if(null == user){
            return "token无效";
        }
        System.out.println(user.toString());
        return user.toString();
    }

}
