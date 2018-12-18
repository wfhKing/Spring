package com.nf147.ssm.passive;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
//        通过 xml 来配置
//        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-cfg.xml");
//        JuiceMaker2 juiceMaker2 = (JuiceMaker2) ctx.getBean(JuiceMaker2.class);
//        System.out.println(juiceMaker2.makeJuice());
        // 从这里我们可以看出，被动创建对象，我们没有主动去创建和 果汁 有关的属性
        // 而是把它交给别人处理，我们直接调用就可以了

        // 通过 java 来配置
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringXML.class);
        JuiceMaker2 juiceMaker2 = (JuiceMaker2) context.getBean(JuiceMaker2.class);
        System.out.println(juiceMaker2.makeJuice());
    }
}
