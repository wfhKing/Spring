package com.nf147.ssm.springAOP.advices;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.util.Random;

public class TimeSpanAdive implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        long start = System.currentTimeMillis();
        lazy();
        System.out.println("方法名：" + methodInvocation.getMethod().getName());
        Object result = methodInvocation.proceed();
        Long span = System.currentTimeMillis() - start;
        System.out.println("共用时：" + span);
        return result;
    }

    public void lazy() {
        try {
            int n = (int) new Random().nextInt(500);
            Thread.sleep(n);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
