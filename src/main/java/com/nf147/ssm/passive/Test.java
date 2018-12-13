package com.nf147.ssm.passive;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-cfg.xml");
        JuiceMaker2 juiceMaker2 = (JuiceMaker2) ctx.getBean("juiceMaker2");
        System.out.println(juiceMaker2.makeJuice());
        // 从这里我们可以看出，被动创建对象，我们没有主动去创建和 果汁 有关的属性
        // 而是把它交给别人处理，我们直接调用就可以了
    }
}
