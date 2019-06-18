package com.example.springbootinterceptor.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Description //注册拦截器
 * @Author zhaobaolin
 * @Date 2019/6/18
 */

@Configuration
public class MvcConfigurer implements WebMvcConfigurer {

    //注册拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        //给指定url增加拦截器 可将要拦截的Url搭配通配符写在配置文件中 /Index/**   excludePathPatterns方法排除url
        registry.addInterceptor(new Interceptor())
                .addPathPatterns("/Index/**")
                .excludePathPatterns("/Index/c")
                .excludePathPatterns("/Index/d")
        ;

        //如果你愿意 可以在这注册多个拦截器 拦截不同的路由
        // registry.addInterceptor(new Interceptor1()).addPathPatterns("/Index1/a");
        // registry.addInterceptor(new Interceptor2()).addPathPatterns("/Index2/a");
        // registry.addInterceptor(new Interceptor3()).addPathPatterns("/Index3/a");

    }

    //跨域配置
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowCredentials(true)
                .allowedMethods("GET", "POST", "DELETE", "PUT","PATCH")
                .allowedHeaders("*")
                .maxAge(3600);
    }


}
