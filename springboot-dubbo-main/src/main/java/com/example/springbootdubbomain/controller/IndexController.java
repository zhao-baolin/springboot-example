package com.example.springbootdubbomain.controller;

import com.example.springbootdubbocore.dto.UserVo;
import com.example.springbootdubbomain.handler.IndexHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
public class IndexController {

    @Autowired
    private IndexHandler indexHandler;

    @RequestMapping("/index")
    @ResponseBody
    public ResponseEntity<UserVo> index()
    {
        UserVo userVo = indexHandler.index();
        return new ResponseEntity<>(userVo, HttpStatus.OK);
    }
}
