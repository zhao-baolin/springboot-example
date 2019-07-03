package com.example.springbootmongodb.controller;

import com.example.springbootmongodb.entity.User;
import com.example.springbootmongodb.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author zhaobaolin
 * @Date 2019/7/4
 */
@RestController
@RequestMapping("/Index")
public class IndexController {

    @Autowired
    private IUserService userService;

    @RequestMapping("/insert")
    public String insert(){
        User user = new User();
        user.setId(2L);
        user.setUserName("张飞aaa");
        user.setSex("男a");
        String result = userService.insert(user);
        System.out.println(result);
        return result;
    }

    @RequestMapping("/findById")
    public String findById(){
        Long id = 1L;
        Object result = userService.findById(id);
        System.out.println(result.toString());
        return result.toString();
    }

    @RequestMapping("/find")
    public String find(){
        Object result = userService.find();
        System.out.println(result.toString());
        return result.toString();
    }

    @RequestMapping("/select")
    public String select(){
        Object result = userService.select();
        System.out.println(result.toString());
        return result.toString();
    }

    @RequestMapping("/count")
    public String count(){
        Object result = userService.count();
        System.out.println(result.toString());
        return result.toString();
    }

    @RequestMapping("/update")
    public String update(){
        Long id = 1L;
        String userName = "张飞";
        String newName = "小张飞";
        Integer newAge = 111;
        Long result = userService.update(id,newName,newAge);
        System.out.println(result.toString());
        return result.toString();
    }

    @RequestMapping("/delete")
    public String delete(){
        Object result = userService.delete();
        System.out.println(result.toString());
        return result.toString();
    }


}
