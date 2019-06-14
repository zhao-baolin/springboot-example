package com.example.springbootioc;

import com.example.springbootioc.config.UserExclude;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@SpringBootApplication
//@SpringBootApplication注解之中包含了@ComponentScan注解 默认扫描范围为当前包以及当前包的所有子包。

//@ComponentScan(basePackages = {"com.example.springbootioc"},excludeFilters = {@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = UserExclude.class)}) //basePackages：重新指定当前项目扫描范围，excludeFilters：指定UserExclude类不装配。

@ComponentScan(excludeFilters = {@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = UserExclude.class)})//不带basePackages属性就是使用默认范围 excludeFilters：指定UserExclude类不装配。  excludeFilters属性的值是一个数组，可以设置多个@ComponentScan.Filter排除多个类
public class SpringbootIoCApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootIoCApplication.class, args);
    }

}
