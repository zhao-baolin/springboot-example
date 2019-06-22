package com.example.springbootjpa.service;

import com.example.springbootjpa.entity.User;

import java.util.List;

/**
 * @Description
 * @Author zhaobaolin
 * @Date 2019/6/19
 */
public interface IUserService {

    List<User> selectAll();

    User find();

    User add();

    List<User> addAll();

    User update();

    int delete();

}
