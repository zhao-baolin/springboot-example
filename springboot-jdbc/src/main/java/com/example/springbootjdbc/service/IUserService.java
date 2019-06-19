package com.example.springbootjdbc.service;

import com.example.springbootjdbc.entity.User;

import java.util.List;

/**
 * @Description
 * @Author zhaobaolin
 * @Date 2019/6/19
 */
public interface IUserService {

    List<User> getUserList(int begin,int limit);

    User getUser(Long id);

    int add(User user);

    Long insertGetId(User user);

    int edit(User user);

    int del(Long id);
}
