package com.example.springbootaop.section;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class UserAround {

	// * 表示任意返回类型
	// com.example.springbootaop.service.impl.UserService 指定类地址
	// getName 指定方法
	// .. 表示任意参数
	@Pointcut("execution(* com.example.springbootaop.service.impl.UserService.getId(..))")
	public void manyAspects() {
	}

	@Around("manyAspects()")
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("准备了环绕开始");
		Object obj = joinPoint.proceed();//调用原方法
		//joinPoint中还可以获取：getArgs()（返回方法参数）、getThis()（返回代理对象）、getTarget()（返回目标）
		System.out.println("环绕过去了");
		return obj;
	}

}
