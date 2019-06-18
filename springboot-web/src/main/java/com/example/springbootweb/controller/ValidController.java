package com.example.springbootweb.controller;

import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * @Description
 * @Author zhaobaolin
 * @Date 2019/6/18
 */
@RestController
@RequestMapping("/Valid")
public class ValidController {

    //数据验证 注意验证不通过不会终止程序 必须要手动遍历验证结果对象Errors查看是否验证不通过
    //访问 http://localhost:8080/Valid/a?sex=33
    @RequestMapping("/a")
    public String a(@Valid UserValid userValid, Errors errors){

        List<ObjectError> list = errors.getAllErrors();
        for (ObjectError objectError : list){
            FieldError fieldError = (FieldError)objectError;
            //输出 userValid --> name ---> 不能为null   userValid --> sex ---> 最大值是10
            System.out.println(fieldError.getObjectName()+" --> "+fieldError.getField()+" ---> "+fieldError.getDefaultMessage());
        }

        //输出：User{name='null', sex=33}
        System.out.println(userValid.toString());
        return userValid.toString();
    }
}
