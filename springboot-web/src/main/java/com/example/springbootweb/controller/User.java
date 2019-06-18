package com.example.springbootweb.controller;

/**
 * @Description
 * @Author zhaobaolin
 * @Date 2019/6/17
 */
public class User{
    private String name;
    private Long sex;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getSex() {
        return sex;
    }

    public void setSex(Long sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", sex=" + sex +
                '}';
    }
}
