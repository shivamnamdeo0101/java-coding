package com.coding.java;

import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

interface VowelsConsonants{
    void printCount(String str);
}


class UsingStream implements VowelsConsonants{

    @Override
    public void printCount(String str) {
        str = str.toLowerCase();
        long vowels = str.chars().parallel()
                .filter(ch -> ch >= 'a' && ch <= 'z')
                .filter(ch -> "aeiou".indexOf(ch) != -1)
                .count();
        System.out.println(vowels);

        long constant = str.chars().parallel()
                .filter(ch -> ch >= 'a' && ch<= 'z')
                .filter(ch -> "aeiou".indexOf(ch) == -1)
                .count();

        System.out.println(vowels + " , "+constant);


    }
}

class UsingSet implements VowelsConsonants{

    @Override
    public void printCount(String str) {
        String temp = str.toLowerCase();
        int v = 0;
        int c = 0;
        Set<Character> vowelSet = new HashSet<>(Set.of('a','e','i','o','u'));
        for (char ch: temp.toCharArray()){
            if(vowelSet.contains(ch)){
                v++;
            }else{
                if(ch >= 'a' && ch <= 'z'){
                    c++;
                }
            }
        }

        System.out.println("Vowels: " + v);
        System.out.println("Consonants: " + c);

    }
}

class UsingLoop implements VowelsConsonants{

    @Override
    public void printCount(String str) {
        String temp = str.toLowerCase();
        int v = 0;
        int c = 0;
        for (char ch: temp.toCharArray()){
            if(ch >= 'a' && ch <= 'z'){
                if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
                    v++;
                }else {
                    c++;
                }
            }
        }
        System.out.println("Vowels: " + v);
        System.out.println("Consonants: " + c);
    }
}

public class Java_5_VowelsConsonants {
    public static void main(String[] args) {
        new UsingLoop().printCount("Hello World");
        new UsingSet().printCount("Hello World");
        new UsingStream().printCount("Hello World");
    }
}
