package com.coding.java;

public class Java_15_Str_Int_Conversion {
    public static void main(String[] args) {
        String str = "123";
        int num1 = Integer.parseInt(str);
        int num2 = Integer.valueOf(str);

        System.out.println(num1 + " , " +num2);

        int n = 123;
        String str1 = Integer.toString(n);
        String str2 = String.valueOf(Integer.valueOf(n));
        String str3 = ""+ n;

        System.out.println(str1 +" , " + str2 +" , " + str3);

        char lower1 = 'a';
        char upper1 = (char)(lower1 - 32);
        System.out.println(upper1); // Output: A

        char upper2 = 'Z';
        char lower2 = (char)(upper2 + 32);
        System.out.println(lower2); // Output: z

        //| Character | ASCII Value |
        //| --------- | ----------- |
        //| `'A'`     | 65          |
        //| `'Z'`     | 90          |
        //| `'a'`     | 97          |
        //| `'z'`     | 122         |

    }
}
