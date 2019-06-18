package com.example.springbootweb.controller;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

/**
 * @Description
 * @Author zhaobaolin
 * @Date 2019/6/17
 */
public class UserValid{

    @NotNull
    private String name;

    @Max(value = 10,message = "最大值是10")
    private Long sex;

    /**
     * @Null 可以为空
     * @NotNll 不能为空
     * @NotBlank 验证字符串不能为空 也包括空字符串
     * @NotEmpty 不能为null或者集合不能为空 其实和@NotBlank没什么区别
     *
     * @Size(min=,max=,message=) 长度限制
     *
     * @Min 最小值
     * @Max 最大值
     * @Range(min=,max=,message=) 限定范围
     *
     * @Email(message=) 邮箱验证
     *
     * @Pattern 自定义正则验证
     */


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
