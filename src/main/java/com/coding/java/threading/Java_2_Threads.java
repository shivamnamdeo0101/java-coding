package com.coding.java.threading;

public class Java_2_Threads {
    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            System.out.println("Thread One ");
        });

        Thread t2 = new Thread(()->{
            System.out.println("Thread Two");
        });

        t1.start();
        t2.start();
    }
}
