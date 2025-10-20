package com.coding.java;

interface Fib{
    void printFib(int n);
}

class UsingDPFib implements Fib{

    @Override
    public void printFib(int n) {
        int[] arr = new int[n];
        arr[0] = 0;
        arr[1] = 1;

        for(int i=2;i<n;i++){
            arr[i] = arr[i-1] + arr[i-2];
        }

        for (int i: arr){
            System.out.println(i);
        }
    }
}

class UsingLoopFib implements Fib{

    @Override
    public void printFib(int n) {
        int a = 0;
        int b = 1;

        System.out.println(a+ "\n"+ b);

        for(int i=2;i<n;i++){
            int c = a +b;
            System.out.println(c);
            a = b;
            b = c;
        }
    }
}

public class Java_7_Fibonacci {
    public static void main(String[] args) {
        new UsingLoopFib().printFib(10);
        new UsingDPFib().printFib(10);
    }
}
