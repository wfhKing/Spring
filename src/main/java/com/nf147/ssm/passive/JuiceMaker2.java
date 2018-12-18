package com.nf147.ssm.passive;

import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

/**
 * 被动创建对象
 * 把果汁交给饮品店处理
 * 我们只要把自己的需求告诉饮品店
 * 之后等待结果就好了
 */
public class JuiceMaker2 {
    private String beverageShop = null;
    private Source source = null;

    public String makeJuice() {
        String juice = "这是一杯由<" + beverageShop + ">饮品店，提供的<" + source.getSize() + "><"
                + source.getSugar() + "><" + source.getFruit() + ">";
        return juice;
    }

    public String getBeverageShop() {
        return beverageShop;
    }

    public void setBeverageShop(String beverageShop) {
        this.beverageShop = beverageShop;
    }

    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }
}
