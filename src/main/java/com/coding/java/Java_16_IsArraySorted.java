package com.coding.java;

import java.util.Arrays;
import java.util.stream.IntStream;

interface IsArraySorted{
    boolean checkSorted(int[] arr);
}


class CheckUsingRecursion implements IsArraySorted{

    public boolean isSorted(int[] arr, int index){
        if(index == arr.length -1){
            return true;
        }
        if(arr[index] > arr[index+1]){
            return false;
        }

        return isSorted(arr,index+1);
    }

    @Override
    public boolean checkSorted(int[] arr) {
        return isSorted(arr,0);
    }
}

class CheckSortedCopy implements IsArraySorted{

    @Override
    public boolean checkSorted(int[] arr) {
        int[] copy = arr.clone();
        Arrays.sort(copy);
        return Arrays.equals(arr,copy);
    }
}

class CheckUsingStream implements IsArraySorted{

    @Override
    public boolean checkSorted(int[] arr) {
        return IntStream.range(0,arr.length-1)
                .allMatch(i -> arr[i] <= arr[i+1]);
    }
}

class CheckUsingLoop implements IsArraySorted{

    @Override
    public boolean checkSorted(int[] arr) {
        for (int i = 0;i<arr.length -1 ; i++){
            if(arr[i] > arr[i+1]){
                return false;
            }
        }
        return true;
    }
}

public class Java_16_IsArraySorted {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(new CheckUsingLoop().checkSorted(arr));
        System.out.println(new CheckUsingStream().checkSorted(arr));
        System.out.println(new CheckSortedCopy().checkSorted(arr));
        System.out.println(new CheckUsingRecursion().checkSorted(arr));
    }
}
