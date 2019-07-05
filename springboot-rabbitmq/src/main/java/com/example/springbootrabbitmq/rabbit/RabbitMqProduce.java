package com.example.springbootrabbitmq.rabbit;

import com.example.springbootrabbitmq.entity.User;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author zhaobaolin
 * @Date 2019/7/5
 */
@Service
public class RabbitMqProduce {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    // rabbit的安装教程请参考：https://www.cnblogs.com/fengyumeng/p/11133924.html


    //消息发送

    public void sendStr(String msg) {
        rabbitTemplate.convertAndSend("str",msg);//发送到str队列
    }

    public void sendUser(User user) {
        rabbitTemplate.convertAndSend("user",user);//发送到user队列
    }

}
