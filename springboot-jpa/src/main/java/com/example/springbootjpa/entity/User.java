package com.example.springbootjpa.entity;

import javax.persistence.*;

/**
 * @Description
 * @Author zhaobaolin
 * @Date 2019/6/19
 */
@Entity
@Table(name = "tb_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //自增主键
    private Long id;

    //和数据库中的字段不相同时需要手动绑定
    @Column(name = "user_name")
    private String userName;

    @Column
    private Integer sex;

    @Column
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
