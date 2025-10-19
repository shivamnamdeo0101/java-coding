package com.coding.java;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

interface LargestNum{
    void printLargestNum(int[] arr);
}

class LargestNumStreamCollection implements LargestNum{

    @Override
    public void printLargestNum(int[] arr) {
        int max = Arrays.stream(arr).max().getAsInt();
        System.out.println(max);
        List<Integer> li = Arrays.stream(arr).boxed().toList();
        int maxby = Collections.max(li);
        System.out.println(maxby);

        Arrays.sort(arr);
        int min = arr[arr.length-1]; // first element after sorting
        System.out.println("Smallest number is " + min);


    }
}

class LargestNumArrayLoop implements LargestNum{

    @Override
    public void printLargestNum(int[] arr) {
        int max = arr[0];

        for(int num:arr){
            if(num > max){
                max = num;
            }
        }
        System.out.println(max);
    }
}

public class Java_4_LargestNum {
    public static void main(String[] args) {
        int[] arr = {3,4,5,632,21,213,4,55,5,6,6};
        new LargestNumArrayLoop().printLargestNum(arr);
        new LargestNumStreamCollection().printLargestNum(arr);
    }
}
