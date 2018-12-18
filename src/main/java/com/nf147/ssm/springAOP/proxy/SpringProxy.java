package com.nf147.ssm.springAOP.proxy;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.framework.ProxyFactory;

public class SpringProxy<T> implements MethodInterceptor {

    public T getProxyObject(Object object) {
        ProxyFactory factory = new ProxyFactory();
        factory.setTarget(object);
        factory.addAdvice(this);
        return (T) factory.getProxy();
    }

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
//        before();
        Object proceed = methodInvocation.proceed();
//        after(proceed);
        return proceed;
    }

    public void before() {
        System.out.println("调用方法前");
    }

    public void after(Object result) {
        System.out.println("调用方法后");
    }
}
