package com.coding.java;

interface PrimeCheck{
    boolean checkPrime(int n);
}

class UsingLoopPrime implements PrimeCheck{

    @Override
    public boolean checkPrime(int n) {
        if(n < 1){
            return false;
        }

        for(int i= 2;i <=n / 2;i++){
            if(n%i == 0) return false;
        }

        return true;

    }
}

public class Java_9_PrimeCheck {
    public static void main(String[] args) {
       UsingLoopPrime u1 =  new UsingLoopPrime();
        System.out.println(u1.checkPrime(2));
    }
}
