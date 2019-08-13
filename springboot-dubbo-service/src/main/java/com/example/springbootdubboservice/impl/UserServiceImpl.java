package com.example.springbootdubboservice.impl;

import com.example.springbootdubbocore.dto.UserVo;
import com.example.springbootdubbocore.interfaces.IUserService;
import org.springframework.stereotype.Service;


@Service("userService")
public class UserServiceImpl implements IUserService {

    @Override
    public UserVo userDetail() {
        System.out.println("这是服务层");
        UserVo userVo = new UserVo();
        userVo.setId(3);
        userVo.setName("张三");
        return userVo;
    }

}
