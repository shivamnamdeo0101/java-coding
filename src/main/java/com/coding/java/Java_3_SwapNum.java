package com.coding.java;

interface SwapNum{
    void swap(int a, int b);
}

class SwapNumByTemp implements SwapNum{

    @Override
    public void swap(int a, int b) {
        System.out.println(a+" , "+b);
        int temp = a ;
        a = b;
        b = temp;
        System.out.println(a+" , "+b);
    }
}

class SwapNumByAddition implements SwapNum{

    @Override
    public void swap(int a, int b) {

        System.out.println(a+" , "+b);

         a = a + b;
         b = a - b;
         a = a - b;

        System.out.println(a+ " , "+b);

    }
}

public class Java_3_SwapNum {
    public static void main(String[] args) {
        new SwapNumByAddition().swap(4,5);
        new SwapNumByTemp().swap(4,5);
    }
}
