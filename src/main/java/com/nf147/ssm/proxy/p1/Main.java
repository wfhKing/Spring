package com.nf147.ssm.proxy.p1;

public class Main {
    // 组合优于继承
    public static void main(String[] args) {
        // cheater 就是一个代理对象
        // 因为它是受 student 委托，完成某些功能
        // 它要完成的主要功能，来自 student
        // 除了委托做的事情，可能还会拓展一些行为
//        Cheater cheater = new Cheater(new Student());
//        cheater.exam();

        Examable s = new Student();
        s.exam(); // 原来的行为

        Examable t = new Cheater(s);
        t.exam();
    }
}
