package com.example.springbootwebsocket.entity;

/**
 * @Description
 * @Author zhaobaolin
 * @Date 2019/6/30
 */
public class RequestMessage {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "RequestMessage{" +
                "name='" + name + '\'' +
                '}';
    }
}
