package com.example.springbootconfig.controller;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * @Description
 * @Author zhaobaolin
 * @Date 2019/6/19
 */

//指定某个前缀将子配置加载到实体中 这个类成了bean 使用的时候直接注入  另外 使用这个东西需要加引入一个包 请查看pom.xml
@EnableConfigurationProperties
@ConfigurationProperties("boot")
public class Entity {
    private String a;
    private String b;
    private String c;
    private String d;

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    public String getD() {
        return d;
    }

    public void setD(String d) {
        this.d = d;
    }

    @Override
    public String toString() {
        return "Entity{" +
                "a='" + a + '\'' +
                ", b='" + b + '\'' +
                ", c='" + c + '\'' +
                ", d='" + d + '\'' +
                '}';
    }
}
