package com.nf147.ssm.springAOP.advices;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class Advices {

    // 前置通知
    public void before(JoinPoint joinPoint) {
        System.out.println("----------前置通知-------------");
        System.out.println("方法名:" + joinPoint.getSignature().getName());
    }

    // 后置通知
    public void after(JoinPoint joinPoint) {
        System.out.println("--------后置通知---------");
    }

    // 环绕通知
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("---------环绕开始-----------");
        Object proceed = joinPoint.proceed();
        System.out.println("---------环绕结束-----------");
        return proceed;
    }

    // 异常通知
    public void afterThrowing(JoinPoint joinPoint, Exception e) {
        System.out.println("-------异常：-------" + e.getMessage());
    }

    // 返回结果通知
    public void afterReturning(JoinPoint joinPoint, Object object){
        System.out.println("--------返回结构通知--------------");
        System.out.println("结果是:" + object);
    }
}
