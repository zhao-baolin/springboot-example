package com.example.springbootmongodb.service;

import com.example.springbootmongodb.entity.User;

import java.util.List;


/**
 * @Description
 * @Author zhaobaolin
 * @Date 2019/7/4
 */
public interface IUserService {

    String insert(User user);

    Object findById(Long id );

    Object find();

    String select();

    Long count();

    Long update(Long id,String userName,Integer age);

    Long delete();


}
