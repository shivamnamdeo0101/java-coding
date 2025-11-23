package com.coding.java.threading;

public class Java_3_Thread {
    public static void main(String[] args) {
        for (int i =1;i<1000;i++){
            Thread t = new Thread(()->{
                System.out.println("Running..." + Thread.currentThread().getName());
            });

            t.start();
        }
    }
}
