package com.company;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        JThread1 jThread1 = new JThread1("JThread1");
        JThread2 jThread2 = new JThread2("JThread2");
        jThread1.start();
        jThread2.start();


        Scanner in = new Scanner(System.in);
        System.out.print("Введите 0 для завершения потоков: ");
        int n = in.nextInt();
        if (n == 0){
            jThread1.disable();
            jThread2.disable();

        }


    }
}
