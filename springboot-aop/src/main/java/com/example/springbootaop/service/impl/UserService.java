package com.example.springbootaop.service.impl;

import com.example.springbootaop.service.IUserService;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author zhaobaolin
 * @Date 2019/6/27
 */
@Service
public class UserService implements IUserService {

    @Override
    public String getName() {
        String name = "小明";
        System.out.println(name);
        return name;
    }

    @Override
    public String getId() {
        String name = "小明的ID";
        System.out.println(name);
        return name;
    }

    @Override
    public String getSex() {
        String sex = "小明的性别不告诉你";
        System.out.println(sex);
        return sex;
    }

}
