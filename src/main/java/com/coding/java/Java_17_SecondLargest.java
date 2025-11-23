package com.coding.java;

import java.util.Arrays;

interface SecondLargest{
    void printNum(int[] arr);
}

class UsingTwoPass implements SecondLargest{

    @Override
    public void printNum(int[] arr) {
        int max = Integer.MIN_VALUE;

        for (int i : arr){
            if(i>max){
                max = i;
            }
        }
        int sec_max = Integer.MIN_VALUE;
        for (int i : arr){
            if(sec_max < max && i < max ){
                sec_max = i;
            }
        }

        System.out.println(sec_max);

    }
}

class UsingOnePass implements SecondLargest{

    @Override
    public void printNum(int[] arr) {
        int first_largest = Integer.MIN_VALUE;
        int second_largest= Integer.MIN_VALUE;

        for (int i:arr){
            if(i>first_largest){
                second_largest = first_largest;
                first_largest = i;
            }else if(i > second_largest && i < first_largest){
                second_largest = i;
            }
        }

        System.out.println(second_largest);
    }
}

class UsingArraySort implements SecondLargest{

    @Override
    public void printNum(int[] arr) {
        Arrays.sort(arr);
        System.out.println(arr[arr.length - 2]);
    }
}

public class Java_17_SecondLargest {
    public static void main(String[] args) {
        int[] arr = {5, 10, 20, 8, 12};
        new UsingArraySort().printNum(arr);
        new UsingOnePass().printNum(arr);
        new UsingTwoPass().printNum(arr);
    }
}
