package com.coding.java;

import java.util.HashMap;
import java.util.TreeMap;

interface OccuranceCount{
    void printCount(String str);
}

class UsingASCIIArr implements OccuranceCount{

    @Override
    public void printCount(String str) {
        int[] arr = new int[256];
        for(char ch: str.toCharArray()){
            arr[ch]++;
        }

        for(int i =0;i<arr.length;i++){
            if(arr[i]>0){
                System.out.println((char) i + " = "+arr[i] );
            }
        }

    }
}

//Use output in sorted manner
class UsingTreeMap implements OccuranceCount{

    @Override
    public void printCount(String str) {
        TreeMap<Character,Integer> map = new TreeMap<>();
        for(char ch: str.toCharArray()){
            if(map.containsKey(ch)){
                map.put(ch,map.get(ch)+1);
            }else{
                map.put(ch,1);
            }

        }
        System.out.println(map);
    }
}

class UsingHashMap implements OccuranceCount{

    @Override
    public void printCount(String str) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(char ch: str.toCharArray()){
            if(map.containsKey(ch)){
                map.put(ch,map.get(ch)+1);
            }else{
                map.put(ch,1);
            }

        }
        System.out.println(map);
    }
}

public class Java_6_Char_Occurrence_Count {
    public static void main(String[] args) {
        new UsingHashMap().printCount("programming");
        new UsingTreeMap().printCount("programming");
        new UsingASCIIArr().printCount("programming");
    }
}
