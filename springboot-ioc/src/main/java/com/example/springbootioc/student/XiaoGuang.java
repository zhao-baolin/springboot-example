package com.example.springbootioc.student;

import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author zhaobaolin
 * @Date 2019/6/14
 */
@Service
public class XiaoGuang implements IStudent {
    @Override
    public void say() {
        System.out.println("我是小光");
    }
}
