package com.nf147.ssm.springAOP.proxy;

import com.nf147.ssm.springAOP.service.IMath;
import com.nf147.ssm.springAOP.service.Math;

import java.util.Random;

// 静态代理
public class MathProxy implements IMath {

    IMath iMath = new Math();

    @Override
    public int add(int n1, int n2) {
        long start = System.currentTimeMillis();
        lazy();
        int result = iMath.add(n1, n2);
        Long span =  System.currentTimeMillis() - start;
        System.out.println("共用时:" + span);
        return result;
    }

    @Override
    public int sub(int n1, int n2) {
        long start = System.currentTimeMillis();
        lazy();
        int result = iMath.sub(n1, n2);
        Long span =  System.currentTimeMillis() - start;
        System.out.println("共用时:" + span);
        return result;
    }

    @Override
    public int mut(int n1, int n2) {
        long start = System.currentTimeMillis();
        lazy();
        int result = iMath.mut(n1, n2);
        Long span =  System.currentTimeMillis() - start;
        System.out.println("共用时:" + span);
        return result;
    }

    public void lazy(){
        try {
            int n = (int)new Random().nextInt(500);
            Thread.sleep(n);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
