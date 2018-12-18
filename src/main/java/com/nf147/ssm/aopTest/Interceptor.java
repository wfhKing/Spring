package com.nf147.ssm.aopTest;

public interface Interceptor {
    // 前置通知
    void before(Object object);

    // 后置通知
    void after(Object object);

    // 返回结果通知
    void afterTrturning(Object object);

    // 异常通知
    void afterThrowing(Object object);
}
