package com.coding.java.threading;

class MyWorker extends Thread{
    private boolean paused = false;

    public synchronized void pauseThread(){
        paused = true;
    }

    public synchronized void resumeThread(){
        paused = false;
        notify();

    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 10; i++) {

                synchronized (this) {
                    while (paused) {
                        wait();   // thread safely paused
                    }
                }

                System.out.println("Working: " + i);
                Thread.sleep(500); // simulate work
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

class Java_5_Thread_Pause {
    public static void main(String[] args) throws InterruptedException {
        MyWorker w1 = new MyWorker();
        w1.start();
        Thread.sleep(1000);
        System.out.println("Pausing...");
        w1.pauseThread();

        Thread.sleep(1000);
        System.out.println("Resumeing...");
        w1.resumeThread();

    }
}
