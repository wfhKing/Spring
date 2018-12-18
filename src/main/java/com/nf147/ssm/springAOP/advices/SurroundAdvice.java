package com.nf147.ssm.springAOP.advices;


import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class SurroundAdvice implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) {
        System.out.println("方法名：" + methodInvocation.getMethod().getName());
        Object proceed = null;
        try {
            proceed = methodInvocation.proceed();
        } catch (Throwable throwable) {
//            throwable.printStackTrace();
            System.out.println("异常:" + throwable.getMessage());
        }
//        System.out.println("返回值:" + proceed);
        return proceed;
    }
}
