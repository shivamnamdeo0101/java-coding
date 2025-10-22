package com.coding.java;

import java.util.*;

interface RemoveDuplicate{
    void printNum(int[] arr);
}


class RemoveDupHashMap implements RemoveDuplicate{

    @Override
    public void printNum(int[] arr) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int num:arr){
            map.put(num,map.getOrDefault(num,0)+1);
        }

        System.out.println(map.keySet());
        System.out.println(map.values());

        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("A", 1);
        hashMap.put("B", 2);
        hashMap.put("C", 3);

        System.out.println(hashMap); // order unpredictable

        Set<Integer> linkedSet = new LinkedHashSet<>();
        linkedSet.add(5);
        linkedSet.add(2);
        linkedSet.add(5); // duplicate ignored
        linkedSet.add(8);

        System.out.println(linkedSet); // [5, 2, 8] — order preserved // Maintains insertion order

    }
}

class RemoveDupBruteDuplicate implements RemoveDuplicate{

    @Override
    public void printNum(int[] arr) {
        List<Integer> newList = new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            if(!newList.contains(arr[i])){
                newList.add(arr[i]);
            }
        }

        System.out.println(newList);
    }
}

public class Java_11_Remove_Duplicates {
    public static void main(String[] args) {
        int[] arr = {1,2,2,3,4,5,5,4,6,7,8,8,9};
        new RemoveDupBruteDuplicate().printNum(arr);
        new RemoveDupHashMap().printNum(arr);
    }
}
