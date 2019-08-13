package com.example.springbootdubboservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.example.springbootdubboservice.*"})
@SpringBootApplication
public class SpringbootDubboServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDubboServiceApplication.class, args);
    }

}
