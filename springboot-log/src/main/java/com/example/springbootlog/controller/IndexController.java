package com.example.springbootlog.controller;

import com.example.springbootlog.common.LogUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author zhaobaolin
 * @Date 2019/6/25
 */
@RestController
@RequestMapping("/Index")
public class IndexController {

    @RequestMapping("/a")
    public String a(){

        LogUtil.log("打印一个日志变得超级简单哦");

        LogUtil.log(LogUtil.LevelEnum.warn,"这个突然出现的warning");

        LogUtil.log(LogUtil.LevelEnum.error,"你说我这个日志工具写的牛不牛呀？");

        return "牛！";
    }
}
