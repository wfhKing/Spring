package com.nf147.ssm.proxy.p3;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class JdkSingProxyGenerator implements InvocationHandler {

    private final Object yaobeidailideduixiang;

    public JdkSingProxyGenerator(Object o) {
        this.yaobeidailideduixiang = o;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("苍茫大地。。你的爱");
        return method.invoke(yaobeidailideduixiang, args); // 调用 yaobeidailideduixiang 原来的方法
    }
}
