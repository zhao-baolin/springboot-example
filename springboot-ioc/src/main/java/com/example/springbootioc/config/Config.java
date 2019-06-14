package com.example.springbootioc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description
 * @Author zhaobaolin
 * @Date 2019/6/14
 */
@Configuration
public class Config {

    //将User类装配成bean  名称是aaa
    @Bean
    public User aaa(){
        return new User();
    }

    //你完全可以使用@Bean这个注解将第三方包中的对象装配到IoC容器中 常见的使用场景为装配数据库连接库
    @Bean("cba")
    public String abc(){
        return new String("你大爷");
    }
}
