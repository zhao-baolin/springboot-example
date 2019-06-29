package com.example.springbootaop.section;


import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class CommonAspect {

	//公共切面 匹配指定包下的所有方法
	@Pointcut("within(com.example.springbootaop.service.impl..*)")
	public void manyAspects() {
	}

	@Before("manyAspects()")
	public void before() {
		System.out.println("公共切面开始了哦 before ......");
	}


}
