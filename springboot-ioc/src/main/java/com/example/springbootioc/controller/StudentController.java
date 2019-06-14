package com.example.springbootioc.controller;

import com.example.springbootioc.student.IStudent;
import com.example.springbootioc.student.XiaoMing;
import com.example.springbootioc.student2.IStudent2;
import com.example.springbootioc.student3.IStudent3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author zhaobaolin
 * @Date 2019/6/14
 */
@RestController
@RequestMapping("/Student")
public class StudentController {

    //@Autowired
    //private IStudent student;//如果IStudent只有一个实现bean，那么这么注入是可以的。

    @Autowired
    private IStudent xiaoGuang;//如果有多个实现bean，那么必须将属性名称改为bean名称，以指定注入哪一个bean，如果装配的时候没有手动定义bean的名称的话，默认是类名首字母转小写其他不变。比如XiaoGuang.java的bean名称默认是xiaoGuang

    @Autowired
    private IStudent2 student2;//虽然IStudents有多个实现bean，但是其中XiaoGuang2类使用了优先注解@Primary，所以这里会优先将XiaoGuang2注入


    @Autowired
    @Qualifier("xiaoMing3")
    private IStudent3 student3;//由于实现IStudent3的bean都使用了优先注解，这时spring又懵逼了，因此这里需要@Qualifier注解来指定注入哪一个bean，


    @RequestMapping("/a")
    public String a(){
        xiaoGuang.say();
        return "a";
    }


    @Autowired
    @RequestMapping("/b")
    public String b(XiaoMing xiaoMing){
        //如果这么玩的话，程序启动就会自动到这里运行一遍，个人觉得不太实用。
        xiaoMing.say();
        return "也可以这么注入哦";
    }

    @RequestMapping("/c")
    public String c(){
        student2.say();
        return "c";
    }

    @RequestMapping("/d")
    public String d(){
        student3.say();
        return "d";
    }


}
