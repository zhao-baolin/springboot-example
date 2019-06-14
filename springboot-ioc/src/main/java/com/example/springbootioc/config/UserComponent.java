package com.example.springbootioc.config;

import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author zhaobaolin
 * @Date 2019/6/14
 */
// @Service，@Repository，@Component 等都是一样的装配bean的注解
// 也可以@Component("user")自定义你的bean的名称 如果不指定名称 像下面这样只用@Component注解，那么IoC容器会把类的第一个字母作为小写，其他不变作为Bean的名称放入IoC容器中，比如下面这个名称就会默认为 user2
@Component
public class UserComponent {

    private int id = 20;
    private String name = "我是UserComponent类的小明";
    private String sex = "男";

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
