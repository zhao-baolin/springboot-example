package com.example.springbootredis.redis;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author zhaobaolin
 * @Date 2019/7/1
 */
@Component
public class RedisListener implements MessageListener {
    @Override
    public void onMessage(Message message, byte[] bytes) {
        System.out.println("收到消息");
        String channel = new String(message.getChannel());
        String body = new String(message.getBody());
        System.out.println("渠道是："+channel);
        System.out.println("内容是："+body);


    }


}
