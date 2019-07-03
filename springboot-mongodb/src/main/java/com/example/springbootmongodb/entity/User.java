package com.example.springbootmongodb.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * @Description
 * @Author zhaobaolin
 * @Date 2019/7/4
 */
@Document
public class User {

    //主键id 对应MongoDB的_id字段，如果没有自定义主键id 则MongoDB把_id的值生成一个唯一字符串
    @Id
    private Long id;

    //设置该属性对应存储的字段名
    @Field("user_name")
    private String userName;

    //没有设置@Field则代表属性名就是字段名
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
