package com.example.springbootrabbitmq.controller;

import com.example.springbootrabbitmq.entity.User;
import com.example.springbootrabbitmq.rabbit.RabbitMqProduce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author zhaobaolin
 * @Date 2019/7/5
 */
@RestController
@RequestMapping("/Index")
public class IndexController {

    @Autowired
    private RabbitMqProduce rabbitMqProduce;

    @RequestMapping("/sendStr")
    public String sendStr(){
        rabbitMqProduce.sendStr("刘亦菲，我喜欢你。");
        return "发送成功";
    }

    @RequestMapping("/sendUser")
    public String sendUser(){
        User user = new User();
        user.setId(1L);
        user.setUserName("张三丰");
        user.setSex("男");
        rabbitMqProduce.sendUser(user);
        return "发送成功";
    }


}
