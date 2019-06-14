package com.example.springbootioc.controller;

import com.example.springbootioc.config.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author zhaobaolin
 * @Date 2019/6/14
 */
@RestController
public class IndexController {

    @Autowired
    private User user;//虽然User类本身没有使用注解进行装配  但是在Config类里面已经将它装配成bean了 所以这里可以进行注入

    @Autowired
    private UserComponent userComponent;

    //@Autowired
    //private UserCondition userCondition;//由于UserCondition类指定在装配DataSource的情况下再装配自己 所以DataSource没有装配 UserCondition也不会被装配  那么这里无法注入 启动会报错


    //@Autowired
    //private UserExclude userExclude; //由于启动类SpringbootIoCApplication类中做了手脚，所以UserExclude不会被装配 那么这里无法注入 启动会报错


    @Autowired
    private UserParam userParam;//直接注入 尽管UserParam的构造函数需要参数 但是参数也自动注入了


    @RequestMapping("/a")
    public String a(){

        //获取装配的bean
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        Object aaa = context.getBean("aaa");
        System.out.println(aaa.toString());
        return aaa.toString();
    }

    @RequestMapping("/b")
    public String b(){
        System.out.println(user.toString());
        return user.toString();
    }

    @RequestMapping("/c")
    public String c(){
        System.out.println(userComponent.toString());
        return userComponent.toString();
    }

    @RequestMapping("/d")
    public String d(){
        System.out.println(userParam.getUserComponent().toString());
        return userParam.getUserComponent().toString();
    }


}
