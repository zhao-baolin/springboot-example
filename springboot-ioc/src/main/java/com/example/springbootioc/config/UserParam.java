package com.example.springbootioc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author zhaobaolin
 * @Date 2019/6/14
 */
@Component
public class UserParam {

    private UserComponent userComponent = null;

    //从构造函数注入
    public UserParam(@Autowired UserComponent userComponent) {
        this.userComponent = userComponent;
    }

    public UserComponent getUserComponent() {
        return userComponent;
    }
}
