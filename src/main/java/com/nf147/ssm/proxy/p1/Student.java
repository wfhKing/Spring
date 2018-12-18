package com.nf147.ssm.proxy.p1;

public class Student implements Examable {
    public void playGame() {
        System.out.println("我玩得很开心，我获得特潇洒");
    }

    @Override
    public void exam() {
        System.out.println("奋笔疾书，完成考题...");
    }
}
