package com.nf147.ssm.springAOP.advices;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan("com.nf147.ssm.springAOP")
public class AopConfig {
    @Bean
    public AspectAdvices aspectAdvices() {
        return new AspectAdvices();
    }
}
