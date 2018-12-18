package com.nf147.ssm.springAOP.proxy;

import com.nf147.ssm.springAOP.advices.TimeSpanAdive;
import org.springframework.aop.framework.ProxyFactory;

public abstract class DynamiceProxy2  {
    public static Object getProxy (Object object){
        ProxyFactory factory = new ProxyFactory();
        factory.setTarget(object);
        factory.addAdvice(new SpringProxy<>());
        factory.addAdvice(new TimeSpanAdive());
        return factory.getProxy();
    }
}
