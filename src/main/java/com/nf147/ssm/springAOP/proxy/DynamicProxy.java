package com.nf147.ssm.springAOP.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Random;

public class DynamicProxy implements InvocationHandler {

    Object object;

    public Object getProxyObject(Object object){
        this.object = object;
        return Proxy.newProxyInstance(
                object.getClass().getClassLoader(),
                object.getClass().getInterfaces(),
                this
        );
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long start = System.currentTimeMillis();
        lazy();
        Object result = method.invoke(object,args);
        Long span = System.currentTimeMillis() - start;
        System.out.println("共用时：" + span);
        return result;
    }

    public void lazy(){
        try {
            int n = (int)new Random().nextInt(500);
            Thread.sleep(n);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
