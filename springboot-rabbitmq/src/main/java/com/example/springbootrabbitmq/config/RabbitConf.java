package com.example.springbootrabbitmq.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description
 * @Author zhaobaolin
 * @Date 2019/7/5
 */
@Configuration
public class RabbitConf {

    //创建两个队列名
    @Bean
    public Queue strQueue(){
        return new Queue("str",true);
    }

    @Bean
    public Queue userQueue(){
        return new Queue("user",true);
    }

}
