package com.nf147.ssm.active;

/**
 *  主动创建对象
 *  搅拌器
 * */
public class Blender {
    /**
     *  搅拌
     *  @Param water 水
     *  @Param fruit 水果
     *  @Param suger 糖
     *  @return 果汁
     * */
    public String mix(String water, String fruit, String suger){
        String juice = "这是一杯由\n液体:" + water + "\n水果:" + fruit + "\n糖:" + suger + "\n组成的水果";
        return juice;
    }
}
