package com.coding.java;

interface Fact{
    void printFact(int n);
}

class FactUsingRecursion implements Fact{

    public static int fact(int n){
        if(n == 0 || n ==1){
            return 1;
        }else {
            return n * fact(n-1);
        }
    }

    @Override
    public void printFact(int n) {
        System.out.println(fact(5));
    }
}

class FactUsingLoop implements Fact{

    @Override
    public void printFact(int n) {
        int fact = 1;
        for(int i =1; i <= n; i++){
            fact = fact * i;
        }
        System.out.println(fact);
    }
}

public class Java_8_Factorial {
    public static void main(String[] args) {
        new FactUsingLoop().printFact(5);
        new FactUsingRecursion().printFact(5);
    }
}
