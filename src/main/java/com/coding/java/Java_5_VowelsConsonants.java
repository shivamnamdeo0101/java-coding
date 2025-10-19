package com.coding.java;

import java.util.Locale;

interface VowelsConsonants{
    void printCount(String str);
}

class UsingLoop implements VowelsConsonants{

    @Override
    public void printCount(String str) {
        String temp = str.toLowerCase();
        for (char ch: temp.toCharArray()){

        }
    }
}

public class Java_5_VowelsConsonants {
    public static void main(String[] args) {
        new UsingLoop().printCount("Hello World");
    }
}
