package com.example.springbootexception.controller;

import com.example.springbootexception.error.BaseException;
import com.example.springbootexception.error.StatusCodeEnum;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author zhaobaolin
 * @Date 2019/6/27
 */
@RestController
@RequestMapping("/Index")
public class IndexController {

    @RequestMapping("/a")
    public String a() throws Exception{
        BaseException.error(StatusCodeEnum.USER_INVALID);
        return "a";
    }
}
