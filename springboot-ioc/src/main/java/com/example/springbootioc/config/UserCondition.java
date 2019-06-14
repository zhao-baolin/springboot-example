package com.example.springbootioc.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

/**
 * @Description
 * @Author zhaobaolin
 * @Date 2019/6/14
 */

@Component
@ConditionalOnBean(DataSource.class) //bean条件装配 指定在DataSource对象装配的情况下再装配自己
//同样 还有一个注解 @ConditionalOnClass 指的是class条件装配 如果classpath中存在指定的类 则装配自己
public class UserCondition {

    private int id = 30;
    private String name = "我是条件装配类的小哈哈哈哈哈";
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
