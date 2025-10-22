package com.coding.java;

interface StrLength{
    void printLength(String str);
}

class UsingLoopStrLenght implements StrLength{

    @Override
    public void printLength(String str) {
        char[] ch = str.toCharArray();
        int len = 0;
        for(int i: ch){
           len++;
        }
        System.out.println("lenght"+len);

        String length_str = String.valueOf(str.lastIndexOf(""));
        System.out.println(str.chars().count());
        System.out.println("Length = " + length_str);
    }
}

public class Java_14_Str_Length_WithOutLength {
    public static void main(String[] args) {
        new UsingLoopStrLenght().printLength("Java");
    }
}
