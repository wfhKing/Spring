package com.nf147.ssm.active;


public class Test {
    public static void main(String[] args) {
//         主动创建项目，Blender, JuiceMaker
        JuiceMaker juiceMaker = new JuiceMaker();
        juiceMaker.setWater("水");
        juiceMaker.setFruit("桃子");
        juiceMaker.setSugar("蜜糖");
        System.out.println(juiceMaker.makJuice());
    }
}
