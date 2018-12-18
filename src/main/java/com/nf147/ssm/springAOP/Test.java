package com.nf147.ssm.springAOP;


import com.nf147.ssm.springAOP.advices.AopConfig;
import com.nf147.ssm.springAOP.advices.BeforeAdive;
import com.nf147.ssm.springAOP.proxy.DynamicProxy;
import com.nf147.ssm.springAOP.proxy.MathProxy;
import com.nf147.ssm.springAOP.service.IMath;
import com.nf147.ssm.springAOP.service.Math;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

    // 静态代理
    IMath math = new MathProxy();

    @org.junit.Test
    public void test01() {
        int n1 = 100, n2 = 5;
        math.add(n1, n2);
        math.sub(n1, n2);
        math.mut(n1, n2);
    }

    // 动态代理
    IMath math2 = (IMath) new DynamicProxy().getProxyObject(new Math());

    @org.junit.Test
    public void test02() {
        int n1 = 100, n2 = 5;
        math2.add(n1, n2);
        math2.sub(n1, n2);
        math2.mut(n1, n2);
    }

    @org.junit.Test
    public void test03() {
//        IMath math3 = (IMath) DynamiceProxy2.getProxy(new Math());
        ProxyFactory proxy = new ProxyFactory();
        proxy.setTarget(new Math());
//        proxy.addAdvice(new SurroundAdvice());
        proxy.addAdvice(new BeforeAdive());
        IMath math3 = (IMath) proxy.getProxy();
        int n1 = 100, n2 = 2;
        math3.add(n1, n2);
        math3.sub(n1, n2);
        math3.mut(n1, n2);
    }

    @org.junit.Test
    public void test04() {
        ApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("beansAOP.xml");
        IMath math4 = (IMath) classPathXmlApplicationContext.getBean("math");
        int n1 = 100, n2 = 2;
        math4.add(n1, n2);
        math4.sub(n1, n2);
        math4.mut(n1, n2);
    }

    @org.junit.Test
    public void test05() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AopConfig.class);
        IMath math5 = ctx.getBean(IMath.class);
        int n1 = 100, n2 = 2;
        math5.add(n1, n2);
        math5.sub(n1, n2);
        math5.mut(n1, n2);

    }
}
