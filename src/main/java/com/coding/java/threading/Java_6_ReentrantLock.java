package com.coding.java.threading;

import java.util.concurrent.locks.ReentrantLock;
//Scenario (real world): Only one cashier serves a customer at a time. like synchronized
class Cashier{
    private final ReentrantLock lock = new ReentrantLock();

    public void serve(String customer){
        //Mutual Exclusion (Mutex) = At a time, only one thread can enter the critical section.
        lock.lock();
        try {
            System.out.println("Serving " + customer);
            Thread.sleep(300);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            lock.unlock();
        }
    }
}

public class Java_6_ReentrantLock {
    public static void main(String[] args) {
        Cashier c = new Cashier();
        new Thread(()-> c.serve("Alice")).start();
        new Thread(()-> c.serve("Bob")).start();
    }
}
