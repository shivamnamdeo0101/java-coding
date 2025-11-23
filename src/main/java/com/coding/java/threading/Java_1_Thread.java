package com.coding.java.threading;

class ShivamThread extends Thread{
    public void run(){
        System.out.println("Shivam Thread");
    }
}

class RachitThread extends Thread{
    public void run(){
        System.out.println("Rachit Thread");
    }
}



public class Java_1_Thread {
    public static void main(String[] args) {
        ShivamThread s = new ShivamThread();
        RachitThread r = new RachitThread();

        s.start();
        r.start();
    }
}
