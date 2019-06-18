package com.example.springbootlanguage.interceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

import java.util.Locale;

/**
 * @Description //注册拦截器
 * @Author zhaobaolin
 * @Date 2019/6/18
 */
@Configuration
public class MvcConfigurer implements WebMvcConfigurer {

    // 国际化解析器
    @Bean
    public LocaleResolver localeResolver() {

        CookieLocaleResolver localeResolver = new CookieLocaleResolver();
        localeResolver.setCookieName("localeCookie");//设置cookie
        localeResolver.setDefaultLocale(Locale.US);//设置默认语言
        localeResolver.setCookieMaxAge(3600);//设置cookie有效期.
        return localeResolver;
    }

    // 创建国际化拦截器
    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
        lci.setParamName("lang");// 设置参数名
        return lci;
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册国际化处理器
        registry.addInterceptor(localeChangeInterceptor());
    }

}
