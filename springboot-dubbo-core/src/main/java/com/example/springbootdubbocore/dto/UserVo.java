package com.example.springbootdubbocore.dto;

public class UserVo extends BaseDTO {

    private long id;
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "UserVo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                "} " + super.toString();
    }
}
