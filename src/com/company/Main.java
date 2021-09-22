package com.company;

public class Main {

    public static void main(String[] args) {

        new JThread1("JThread1").start();
        new JThread2("JThread2").start();

    }
}
