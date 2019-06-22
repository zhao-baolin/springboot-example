package com.example.springbootjpa.controller;

import com.example.springbootjpa.entity.User;
import com.example.springbootjpa.service.IUserService;
import com.example.springbootjpa.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description
 * @Author zhaobaolin
 * @Date 2019/6/19
 */
@RestController
@RequestMapping("/Index")
public class IndexController {

    @Autowired
    private IUserService userService;


    @RequestMapping("/list")
    public String list(){
        List<User> list = userService.selectAll();
        System.out.println(list.toString());
        return list.toString();
    }

    @RequestMapping("/find")
    public String user(){
        User user = userService.find();
        System.out.println(user);
        return user.toString();
    }

    @RequestMapping("/add")
    public String add(){
        User user = userService.add();
        System.out.println(user);
        return user.toString();
    }

    @RequestMapping("/addAll")
    public String addAll(){
        List<User> user = userService.addAll();
        System.out.println(user);
        return user.toString();
    }

    @RequestMapping("/update")
    public String update(){
        User user = userService.update();
        System.out.println(user);
        return user.toString();
    }

    @RequestMapping("/delete")
    public String delete(){
        Integer res = userService.delete();
        System.out.println(res);
        return res.toString();
    }


}
