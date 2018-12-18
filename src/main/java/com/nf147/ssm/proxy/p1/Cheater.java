package com.nf147.ssm.proxy.p1;

public class Cheater implements Examable {
    private final Examable student;

    public Cheater(Examable student) {
        this.student = student;
    }

    @Override
    public void exam() {
        System.out.println("苍茫的。。。我的爱");
        student.exam();
    }
}
