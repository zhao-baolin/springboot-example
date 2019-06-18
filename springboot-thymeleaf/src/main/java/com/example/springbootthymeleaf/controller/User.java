package com.example.springbootthymeleaf.controller;

/**
 * @Description
 * @Author zhaobaolin
 * @Date 2019/6/18
 */
public class User {
    private String name = "小花";
    private int age = 10;

    public User() {
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
