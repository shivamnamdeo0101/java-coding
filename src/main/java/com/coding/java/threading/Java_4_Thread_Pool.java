package com.coding.java.threading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Java_4_Thread_Pool {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(5);  // 5 threads only

        for (int i = 1; i<100;i++){
            int task = i;

            pool.submit(()->{
                System.out.println("Task " + task + " Excuted " + Thread.currentThread().getName());
            });
        }

        for (int i = 1; i <= 10; i++) {
            int id = i;

            pool.submit(() -> {
                synchronized (pool) {
                    System.out.println("Task " + id +
                            " executed by " + Thread.currentThread().getName());
                }
            });
        }
        //synchronized kr dia h at a time 1 thread will use synchronized with pool
//        Imagine 5 log (5 threads) aur 1 single bathroom (lock pool object).
//        Ek banda andar jaayega → lock
//        Baaki 4 door pe wait karenge
//        Jab pehla banda bahar niklega → lock release
//        Fir doosra banda jaayega
//        And so on…
    }
}
