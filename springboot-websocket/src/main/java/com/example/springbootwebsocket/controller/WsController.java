package com.example.springbootwebsocket.controller;

import com.example.springbootwebsocket.entity.RequestMessage;
import com.example.springbootwebsocket.entity.ResponseMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

/**
 * @Description
 * @Author zhaobaolin
 * @Date 2019/6/30
 */
@Controller
public class WsController {

    //广播
    @MessageMapping("/hello")
    @SendTo("/topic/hello")
    public ResponseMessage hello(RequestMessage message){
        return new ResponseMessage(message.getName()+"：大家好，我是"+message.getName());
    }

}
