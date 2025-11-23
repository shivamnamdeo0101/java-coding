package com.coding.java.threading;

//tryLock() — non-blocking attempt
//Scenario: A delivery driver checks if the loading dock is free; if busy, he moves on (won’t wait).
//Why: Avoid blocking; skip work if lock not available.
//Behaviour: One truck loads; other leaves immediately. synchronized can’t do this.

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

class Dock{
    private final ReentrantLock lock = new ReentrantLock();

    public void tryLoad(String truckName) throws InterruptedException {
        if(lock.tryLock(1000, TimeUnit.MILLISECONDS)){
           try{
               System.out.println("Loading Truck " + truckName);
               Thread.sleep(2000);
           }catch (InterruptedException e){
               Thread.interrupted();
           }finally {
               lock.unlock();
           }
        }else{
            System.out.println("Found the dock busy and leaves "+ truckName);
        }
    }
}

public class Java_7_Non_Blocking_Lock {
    public static void main(String[] args) {
        Dock d = new Dock();
        new Thread(() -> {
            try {
                d.tryLoad("Rachit Ka Truck");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();

        new Thread(() -> {
            try {
                d.tryLoad("Shivam Ka Truck");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }
}
