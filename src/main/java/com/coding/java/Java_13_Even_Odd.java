package com.coding.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

interface EvenOdd{
    void printEvenOdd(int[] arr);
}

class EvenOddUsingStream implements EvenOdd{

    @Override
    public void printEvenOdd(int[] arr) {
        List<Integer> evens = Arrays.stream(arr)
                .filter(n -> n % 2 == 0)
                .boxed()
                .toList();
        List<Integer> odd = Arrays.stream(arr)
                .filter(n -> n%2 != 0)
                .boxed()
                .toList();

        System.out.println(evens);
        System.out.println(odd);

    }
}

class EvenOddUsingLoop implements EvenOdd{

    @Override
    public void printEvenOdd(int[] arr) {
        ArrayList<Number> even = new ArrayList<>();
        ArrayList<Number> odd = new ArrayList<>();

        for(int num : arr){
            if(num % 2 == 0){
                even.add(num);
            }else{
                odd.add(num);
            }
        }
        System.out.println(even);
        System.out.println(odd);
    }
}

public class Java_13_Even_Odd {
    public static void main(String[] args) {
        int[] arr = {10, 13, 8, 5, 22, 9};
        new EvenOddUsingLoop().printEvenOdd(arr);
        new EvenOddUsingStream().printEvenOdd(arr);
    }
}
