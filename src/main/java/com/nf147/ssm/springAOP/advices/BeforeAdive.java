package com.nf147.ssm.springAOP.advices;

import org.springframework.aop.MethodBeforeAdvice;
import java.lang.reflect.Method;

public class BeforeAdive implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
//        System.out.println("--------前置通知-------");
        System.out.println("方法名：" + method.getName());
    }
}
