package com.nf147.ssm.active;

/**
 * 果汁生成器
 */
public class JuiceMaker {
    private Blender blender = null; // 搅拌机
    private String water; // 水
    private String fruit; // 水果
    private String sugar; // 糖

    /**
     *  果汁生成
     * */
    public String makJuice(){
        blender = new Blender();
        return blender.mix(water,fruit,sugar);
    }

    public Blender getBlender() {
        return blender;
    }

    public void setBlender(Blender blender) {
        this.blender = blender;
    }

    public String getWater() {
        return water;
    }

    public void setWater(String water) {
        this.water = water;
    }

    public String getFruit() {
        return fruit;
    }

    public void setFruit(String fruit) {
        this.fruit = fruit;
    }

    public String getSugar() {
        return sugar;
    }

    public void setSugar(String sugar) {
        this.sugar = sugar;
    }
}
