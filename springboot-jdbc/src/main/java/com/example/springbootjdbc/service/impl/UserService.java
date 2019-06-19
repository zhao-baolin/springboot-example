package com.example.springbootjdbc.service.impl;

import com.example.springbootjdbc.dao.UserDao;
import com.example.springbootjdbc.entity.User;
import com.example.springbootjdbc.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description  用户服务层
 * @Author zhaobaolin
 * @Date 2019/6/19
 */
@Service
public class UserService implements IUserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> getUserList(int begin,int limit) {
        List<User> list = userDao.selectAll(begin,limit);
        System.out.println(list.toString());

        System.out.println("我查完了，还可以继续做一些业务逻辑呢");

        return list;
    }

    @Override
    public User getUser(Long id) {
        return userDao.findUser(id);
    }

    @Override
    public int add(User user) {
        return userDao.insertUser(user);
    }

    @Override
    public Long insertGetId(User user) {
        return userDao.insertGetId(user);
    }

    @Override
    public int edit(User user) {
        return userDao.updateUser(user);
    }

    @Override
    public int del(Long id) {
        return userDao.delete(id);
    }
}
