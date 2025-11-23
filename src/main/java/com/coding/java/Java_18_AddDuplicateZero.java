package com.coding.java;

import java.util.ArrayList;
import java.util.Arrays;

public class Java_18_AddDuplicateZero {
    public static void main(String[] args) {
        int[] arr = {1,0,2,3,0,4,5,0};
        ArrayList<Integer> list = new ArrayList<>();
        for (int i:arr){
            list.add(i);


            if(i == 0){

                list.add(0);
            }
            if(list.toArray().length == arr.length){
                break;
            }

        }
        for (int i=0;i<arr.length;i++){
            arr[i] = list.get(i);
        }
        System.out.println(Arrays.toString(arr));
    }
}
