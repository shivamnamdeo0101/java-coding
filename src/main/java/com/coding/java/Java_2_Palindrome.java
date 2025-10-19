package com.coding.java;

import java.util.Stack;

interface Palindrome{
    boolean checkPalindrome(String str);
}

class PalindromeRecursive implements Palindrome{

    private static boolean check(String s,int left, int right){
        if(left >= right) return true;

        if (s.charAt(left) != s.charAt(right)) return false;

        return check(s,left+1,right -1);
    }

    @Override
    public boolean checkPalindrome(String str) {
        if(str == null) return false;
        return check(str, 0, str.length() - 1);
    }
}


class PalindromeStack implements Palindrome{

    @Override
    public boolean checkPalindrome(String str) {

        if(str ==null) return false;

        Stack<Character> stack = new Stack<>();
        for(char ch:str.toCharArray()){
            stack.push(ch);
        }

        for(char ch: str.toCharArray()){
            if(ch != stack.pop()){
                return false;
            }
        }


        return true;
    }
}

class PalindromeTwoPointers implements Palindrome{

    @Override
    public boolean checkPalindrome(String str) {
        if(str == null){
            return false;
        }

        int left = 0;
        int right = str.length() - 1;

        while (left < right){
            if(str.charAt(left) != str.charAt(right)){
                return false;
            }
            left++;
            right--;
        }

        return true;

    }
}

public class Java_2_Palindrome {
    public static void main(String[] args) {
        System.out.println(new PalindromeTwoPointers().checkPalindrome("madam"));
        System.out.println(new PalindromeStack().checkPalindrome("madam"));
        System.out.println(new PalindromeRecursive().checkPalindrome("madam"));
    }
}
