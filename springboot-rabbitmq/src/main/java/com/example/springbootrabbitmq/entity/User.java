package com.example.springbootrabbitmq.entity;

import java.io.Serializable;

/**
 * @Description
 * @Author zhaobaolin
 * @Date 2019/7/5
 */
public class User implements Serializable {

    private static final long serialVersionUID = 4359709211352400087L;

    private Long id;
    private String userName;
    private String sex;

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
                ", userName='" + userName + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
