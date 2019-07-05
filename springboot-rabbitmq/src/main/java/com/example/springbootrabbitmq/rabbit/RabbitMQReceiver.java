package com.example.springbootrabbitmq.rabbit;

import com.example.springbootrabbitmq.entity.User;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author zhaobaolin
 * @Date 2019/7/5
 */
@Component
public class RabbitMQReceiver {

    //消息接收

    @RabbitListener(queues = "str")
    public void receiverStr(String msg){
        System.out.println("收到str队列的消息："+msg);
    }

    @RabbitListener(queues = "user")
    public void receiverUser(User user){
        System.out.println("收到user队列的消息"+user.toString());
    }

}
