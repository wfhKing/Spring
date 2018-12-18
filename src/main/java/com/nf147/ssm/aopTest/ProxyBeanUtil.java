package com.nf147.ssm.aopTest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyBeanUtil implements InvocationHandler {

    // 被代理的对象
    private Object object;

    // 拦截器
    private Interceptor interceptor = null;

    /**
     * 获取动态代理对象
     *
     * @param object      被代理的对象
     * @param interceptor 拦截器
     * @return 动态代理对象
     */
    public static Object getBean(Object object, Interceptor interceptor) {
        // 使用当前类，作为代理方法，此时被代理对象执行方法的时候，会进入到类的 invoke 方法里
        ProxyBeanUtil proxyBeanUtil = new ProxyBeanUtil();
        // 保存被代理对象
        proxyBeanUtil.object = object;
        // 生成代理对象，并绑定代理方法
        proxyBeanUtil.interceptor = interceptor;
        return Proxy.newProxyInstance(
                object.getClass().getClassLoader(),
                object.getClass().getInterfaces(),
                proxyBeanUtil
        );
    }


    /**
     * 代理方法
     *
     * @param proxy  代理对象
     * @param method 当前调度方法
     * @param args   参数
     * @return 方法返回
     * @throws Throwable 异常
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) {
        Object object = null;
        // 是否产生异常
        boolean b = false;
        interceptor.before(object);
        // 反射原有方法
        try {
            object = method.invoke(object, args);
        } catch (Exception e) {
            b = true;
        }
        if (b) {
            interceptor.afterThrowing(object);
        } else {
            interceptor.afterTrturning(object);
        }
        return object;
    }
}
