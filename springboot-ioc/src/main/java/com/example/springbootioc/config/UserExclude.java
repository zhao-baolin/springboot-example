package com.example.springbootioc.config;

import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author zhaobaolin
 * @Date 2019/6/14
 */

//正常情况下@Component注解会被扫描到并且自动进行装配，但是这个类不会被装配，详情请查看启动类 SpringbootIoCApplication
@Component
public class UserExclude {

    private int id = 30;
    private String name = "我是要排除的人";
    private String sex = "女";

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }


}
