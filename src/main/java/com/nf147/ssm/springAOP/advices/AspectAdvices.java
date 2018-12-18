package com.nf147.ssm.springAOP.advices;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AspectAdvices {
    @Pointcut("execution(* com.nf147.ssm.springAOP.service.Math.a*(..))")
    public void print(){}

    @Before("print()")
    public void before() {
        System.out.println("------------before-----------");
    }

    @After("print()")
    public void after() {
        System.out.println("-------------after------------");
    }

//    @Around("execution(* com.nf147.ssm.springAOP.service.Math.s*(..))")
//    public void around(ProceedingJoinPoint joinPoint) {
//        System.out.println("-------------around before------------");
//        try {
//            joinPoint.proceed();
//        } catch (Throwable throwable) {
//            throwable.printStackTrace();
//        }
//        System.out.println("-------------around after------------");
//    }

    @AfterThrowing("execution(* com.nf147.ssm.springAOP.service.Math.m*(..))")
    public void afterThrowing() {
        System.out.println("-----------afterThrowing--------------");
    }

    @AfterReturning("execution(* com.nf147.ssm.springAOP.service.Math.m*(..))")
    public void afterReturning() {
        System.out.println("-------------afterTeturning-------------");
    }

}
