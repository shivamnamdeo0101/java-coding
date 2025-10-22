package com.coding.java;

import java.util.*;

interface ReverseWordStr{
    void printRevStr(String str);
}

class RevUsingCollection implements ReverseWordStr{

    @Override
    public void printRevStr(String str) {
        List<String> list_Str = Arrays.asList(str.split(" "));
        Collections.reverse(list_Str);
        String rev = String.join(" ",list_Str);
        System.out.println(rev);
    }
}

class ReverseUsingStack implements ReverseWordStr{

    @Override
    public void printRevStr(String str) {
        Stack<String> stack = new Stack<>();
        for(String word: str.split(" ")){
            stack.push(word);
        }
        StringBuilder stringB = new StringBuilder();
        while (!stack.isEmpty()){
            stringB.append(stack.pop());
            stringB.append(" ");
        }

        System.out.println(stringB);
    }
}

public class Java_12_ReverseWordString {
    public static void main(String[] args) {
        new ReverseUsingStack().printRevStr("Java is Fun");
        new RevUsingCollection().printRevStr("Java is really fun");
    }
}
