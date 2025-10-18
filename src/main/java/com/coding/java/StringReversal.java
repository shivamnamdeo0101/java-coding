package com.coding.java;

interface StringReverse{
    void makeReverseStr(String str);
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
    }
}
