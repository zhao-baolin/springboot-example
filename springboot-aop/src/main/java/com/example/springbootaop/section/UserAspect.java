package com.example.springbootaop.section;


import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class UserAspect {

	// * 表示任意返回类型
	// com.example.springbootaop.service.impl.UserService 指定类地址
	// getName 指定方法  可以用通配符*号代替，表明植入所有方法。
	// .. 表示任意参数
	@Pointcut("execution(* com.example.springbootaop.service.impl.UserService.getName(..))")
	public void manyAspects() {
	}

	@Before("manyAspects()")
	public void before() {
		System.out.println("切面开始了哦 before ......");
	}

	@After("manyAspects()")
	public void after() {
		System.out.println("方法切面完成了哦 after ......");
	}

	@AfterReturning("manyAspects()")
	public void afterReturning() {
		System.out.println("已经return了 afterReturning ......");
	}

	@AfterThrowing("manyAspects()")
	public void afterThrowing() {
		System.out.println("抛出异常我才会出现的 afterThrowing ......");
	}

}
