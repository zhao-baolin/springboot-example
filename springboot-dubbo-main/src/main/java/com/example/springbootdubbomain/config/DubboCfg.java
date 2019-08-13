package com.example.springbootdubbomain.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:dubbo/dubbo.properties")
@ImportResource({ "classpath:dubbo/dubbo-*.xml" })
public class DubboCfg {}
