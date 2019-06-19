package com.example.springbootjdbc.controller;

import com.example.springbootjdbc.entity.User;
import com.example.springbootjdbc.enums.SexEnum;
import com.example.springbootjdbc.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    IUserService userService;

    //查询列表
    //访问：http://localhost:8080/Index/list?limit=1
    @RequestMapping("/list")
    public String list(@RequestParam(value = "begin",defaultValue = "0") int begin,@RequestParam(value = "limit",defaultValue = "10") int limit){
        List<User> list = userService.getUserList(begin,limit);
        return list.toString();
    }


    //查询单条数据
    //访问：http://localhost:8080/Index/user/2
    @RequestMapping("/user/{id}")
    public String getUser(@PathVariable("id") Long id){
        User user = userService.getUser(id);
        System.out.println(user.getUserName()+"的性别是："+ SexEnum.getValueByKey(user.getSex()).getValue());
        return user.toString();
    }

    //插入数据
    //访问：http://localhost:8080/Index/add?userName=小王八&sex=0&age=200
    @RequestMapping("/add")
    public String add(User user){
        Integer integer = userService.add(user);
        System.out.println(integer);
        return integer.toString();
    }

    //插入数据返回自增id
    //访问：http://localhost:8080/Index/insertGetId?userName=小王八2&sex=1&age=3000
    @RequestMapping("/insertGetId")
    public String insertGetId(User user){
        Long id = userService.insertGetId(user);
        System.out.println(id);
        return id.toString();
    }

    //更新数据
    //访问：http://localhost:8080/Index/edit?age=2000&id=3
    @RequestMapping("/edit")
    public String edit(User user){
        Integer integer = userService.edit(user);
        System.out.println(integer);
        return integer.toString();
    }


    //删除数据
    //访问：http://localhost:8080/Index/del?id=3
    @RequestMapping("/del")
    public String del(Long id){
        Integer integer = userService.del(id);
        System.out.println(integer);
        return integer.toString();
    }


}
