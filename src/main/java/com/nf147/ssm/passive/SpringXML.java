package com.nf147.ssm.passive;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 通过 java 来配置
@Configuration
public class SpringXML {
    @Bean
    public Source getSource(){
        Source source = new Source();
        source.setFruit("橙汁");
        source.setSugar("少糖");
        source.setSize("大杯");
        return source;
    }
    @Bean
    public JuiceMaker2 getJuiceMaker2(){
        JuiceMaker2 juiceMaker2 = new JuiceMaker2();
        juiceMaker2.setBeverageShop("贡茶");
        juiceMaker2.setSource(getSource());
        return juiceMaker2;
    }
}
