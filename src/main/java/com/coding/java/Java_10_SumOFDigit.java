package com.coding.java;

interface SumDigit{
    void printSum(int num);
}

class SumDigitRecursion implements SumDigit{

    public int makeSum(int n){
        n = Math.abs(n);
        if (n == 0) return 0;

        return n % 10 + makeSum( n / 10);

    }

    @Override
    public void printSum(int num) {
        System.out.println(makeSum(num));

        // 3️⃣ Using Java 8 Stream (String-based)
        int s = String.valueOf(Math.abs(num))
                .chars()                       // stream of characters
                .map(ch -> ch - '0')           // convert char to int
                .sum();
        System.out.println(s+" Sum");
        // ⏱️ O(d) | 🧠 O(d) where d = number of digits

    }
}

class SumDigitIterative implements SumDigit{

    @Override
    public void printSum(int num) {
        int sum = 0;
        while(num>0){
            int temp = num % 10;  //123 % 10 => 3
            sum += temp;    //0 + 3
            num = num / 10; // num = 120 / 10
        }
        System.out.println(sum);
    }
}

public class Java_10_SumOFDigit {
    public static void main(String[] args) {
        new SumDigitIterative().printSum(123);
        new SumDigitRecursion().printSum(123);
    }
}
