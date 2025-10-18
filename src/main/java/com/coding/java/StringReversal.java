package com.coding.java;

import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

interface StringReverse{
    void makeReverseStr(String str);
}


class StrReverseCollectionAPIStream implements StringReverse{

    @Override
    public void makeReverseStr(String str) {

        List<Character> chars = str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toList());

        Collections.reverse(chars);

        String reversed = chars.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());

        System.out.println(reversed);
    }
}

class StrReverseStackLIFO implements StringReverse{

    @Override
    public void makeReverseStr(String str) {
        Stack<Character> stckk = new Stack<>();
        for(char c: str.toCharArray()){
            stckk.push(c);
        }
        StringBuilder reverse = new StringBuilder();
        while (!stckk.isEmpty()){
            reverse.append(stckk.pop());
        }

        System.out.println(reverse);

    }
}


class StrReverseRecursion implements StringReverse {

    public String reverse(String str) {
        if (str.isEmpty()) {
            return str;
        } else {
            return reverse(str.substring(1)) + str.charAt(0);
        }
    }

    @Override
    public void makeReverseStr(String str) {
        String s = reverse(str);
        System.out.println(s);
    }
}


class StrReverseCharArray implements StringReverse{

    @Override
    public void makeReverseStr(String str) {
        char[] charArray = str.toCharArray();
        String reverse = "";
        for(int i=charArray.length - 1;i>=0;i--){
            reverse+=charArray[i];
        }

        System.out.println(reverse);
    }
}

class StrReverseStringBuffer implements StringReverse{

    @Override
    public void makeReverseStr(String str) {
        System.out.println(new StringBuffer(str).reverse().toString());
    }
}

class StrReverseCharLoop implements StringReverse{
    @Override
    public void makeReverseStr(String str){
        String reverse = "";
        for(int i=str.length() - 1;i >=0;i--){
            reverse+=str.charAt(i);
        }

        System.out.println(reverse);

    }
}

class StrReverseByStrBuilder implements StringReverse{

    @Override
    public void makeReverseStr(String str){
        String reverseStr = String.valueOf(str);
        System.out.println(new StringBuilder(reverseStr).reverse().toString());
    }

}

public class StringReversal {
    public static void main(String[] args) {
        StrReverseByStrBuilder str1 = new StrReverseByStrBuilder();
        str1.makeReverseStr("Shivam");

        StrReverseCharLoop str2 = new StrReverseCharLoop();
        str2.makeReverseStr("Shivam");

        StrReverseStringBuffer str3 = new StrReverseStringBuffer();
        str3.makeReverseStr("Shivam");

        StrReverseCharArray str4 = new StrReverseCharArray();
        str4.makeReverseStr("Shivam");

        StrReverseRecursion str5 = new StrReverseRecursion();
        str5.makeReverseStr("Shivam");

        StrReverseStackLIFO str6 = new StrReverseStackLIFO();
        str6.makeReverseStr("Shivam");

        StrReverseCollectionAPIStream str7 = new StrReverseCollectionAPIStream();
        str7.makeReverseStr("Shivam");
    }
}
