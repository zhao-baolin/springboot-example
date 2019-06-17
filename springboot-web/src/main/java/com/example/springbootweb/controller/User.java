package com.example.springbootweb.controller;

import java.io.Serializable;

/**
 * @Description
 * @Author zhaobaolin
 * @Date 2019/6/17
 */
public class User implements Serializable {
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
