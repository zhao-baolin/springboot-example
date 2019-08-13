package com.example.springbootdubbomain.handler;

import com.example.springbootdubbocore.dto.UserVo;
import com.example.springbootdubbocore.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class IndexHandler {

    @Autowired
    private IUserService userService;

    public UserVo index()
    {
        UserVo userVo = userService.userDetail();
        return userVo;
    }
}
