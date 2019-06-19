package com.example.springbootjdbc.entity;

import com.example.springbootjdbc.enums.SexEnum;

/**
 * @Description
 * @Author zhaobaolin
 * @Date 2019/6/19
 */
public class User {
    private Long id;
    private String userName;
    private Integer sex;
    private Integer age;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                '}';
    }
}
