package com.example.springbootioc.student3;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author zhaobaolin
 * @Date 2019/6/14
 */
@Service
@Primary
public class XiaoGuang3 implements IStudent3 {
    @Override
    public void say() {
        System.out.println("我是学生接口实现的第三 个 小光");
    }
}
