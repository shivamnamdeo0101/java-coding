package com.coding.java;

import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * 🔹 Common interface for all string reversal strategies.
 * Each implementation class defines its own way to reverse a string.
 */
interface StringReverse {
    void makeReverseStr(String str);
}

/**
 * ✅ Approach 1: Using Java Collections + Stream API
 *
 * 🧠 Use Case:
 * - Ideal for Java 8+ developers who prefer functional programming style.
 * - Useful when you’re already working with Streams or Lists.
 *
 * ⚡ Benefit:
 * - Expressive and modern (uses Collectors and lambda expressions).
 *
 * ⚠️ Drawback:
 * - Creates intermediate lists → slightly higher memory use.
 *
 * ⏱️ Time Complexity: O(n)
 * 💾 Space Complexity: O(n) (extra list to hold characters)
 */
class StrReverseCollectionAPIStream implements StringReverse {

    @Override
    public void makeReverseStr(String str) {
        // Convert string to list of characters
        List<Character> chars = str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toList());

        // Reverse the list
        Collections.reverse(chars);

        // Join characters back to form reversed string
        String reversed = chars.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());

        System.out.println(reversed);
    }
}

/**
 * ✅ Approach 2: Using Stack (LIFO)
 *
 * 🧠 Use Case:
 * - Demonstrates stack behavior (Last-In-First-Out).
 * - Excellent for data structure learning and interviews.
 *
 * ⚡ Benefit:
 * - Conceptually clear and easy to visualize.
 *
 * ⚠️ Drawback:
 * - Slightly less efficient due to push/pop operations.
 *
 * ⏱️ Time Complexity: O(n)
 * 💾 Space Complexity: O(n) (stack stores all characters)
 */
class StrReverseStackLIFO implements StringReverse {

    @Override
    public void makeReverseStr(String str) {
        Stack<Character> stack = new Stack<>();

        // Push all characters into the stack
        for (char c : str.toCharArray()) {
            stack.push(c);
        }

        // Pop all characters to build the reversed string
        StringBuilder reverse = new StringBuilder();
        while (!stack.isEmpty()) {
            reverse.append(stack.pop());
        }

        System.out.println(reverse);
    }
}

/**
 * ✅ Approach 3: Using Recursion
 *
 * 🧠 Use Case:
 * - Good for demonstrating recursion and string decomposition.
 *
 * ⚡ Benefit:
 * - Elegant and concise, no loops needed.
 *
 * ⚠️ Drawback:
 * - Not memory-efficient (uses call stack frames).
 * - Avoid for long strings due to StackOverflowError.
 *
 * ⏱️ Time Complexity: O(n)
 * 💾 Space Complexity: O(n) (due to recursion stack)
 */
class StrReverseRecursion implements StringReverse {

    private String reverse(String str) {
        if (str.isEmpty()) {
            return str; // Base case
        } else {
            // Recursive call on substring excluding first character
            return reverse(str.substring(1)) + str.charAt(0);
        }
    }

    @Override
    public void makeReverseStr(String str) {
        System.out.println(reverse(str));
    }
}

/**
 * ✅ Approach 4: Using Character Array
 *
 * 🧠 Use Case:
 * - Perfect for manual control in low-level logic or interviews.
 *
 * ⚡ Benefit:
 * - Simple logic, easy to follow.
 *
 * ⚠️ Drawback:
 * - String concatenation inside loop is inefficient (creates new String each time).
 *
 * ⏱️ Time Complexity: O(n²) (due to String concatenation)
 * 💾 Space Complexity: O(n) (char array)
 */
class StrReverseCharArray implements StringReverse {

    @Override
    public void makeReverseStr(String str) {
        char[] charArray = str.toCharArray();
        String reverse = "";

        // Append each character from end to start
        for (int i = charArray.length - 1; i >= 0; i--) {
            reverse += charArray[i];  // Creates new string each iteration (costly)
        }

        System.out.println(reverse);
    }
}

/**
 * ✅ Approach 5: Using StringBuffer.reverse()
 *
 * 🧠 Use Case:
 * - Use when thread safety is required (multi-threaded environments).
 *
 * ⚡ Benefit:
 * - Built-in `reverse()` method, very clean and efficient.
 * - Thread-safe because StringBuffer is synchronized.
 *
 * ⚠️ Drawback:
 * - Slightly slower due to synchronization overhead.
 *
 * ⏱️ Time Complexity: O(n)
 * 💾 Space Complexity: O(n)
 */
class StrReverseStringBuffer implements StringReverse {

    @Override
    public void makeReverseStr(String str) {
        System.out.println(new StringBuffer(str).reverse().toString());
    }
}

/**
 * ✅ Approach 6: Using simple for-loop with String concatenation
 *
 * 🧠 Use Case:
 * - Great for beginners learning loops and indexing.
 *
 * ⚡ Benefit:
 * - Easy to understand, no advanced concepts.
 *
 * ⚠️ Drawback:
 * - Inefficient due to immutable string concatenation in every loop iteration.
 *
 * ⏱️ Time Complexity: O(n²)
 * 💾 Space Complexity: O(n)
 */
class StrReverseCharLoop implements StringReverse {

    @Override
    public void makeReverseStr(String str) {
        String reverse = "";

        // Append characters from end to start
        for (int i = str.length() - 1; i >= 0; i--) {
            reverse += str.charAt(i);  // costly operation for long strings
        }

        System.out.println(reverse);
    }
}

/**
 * ✅ Approach 7: Using StringBuilder.reverse()
 *
 * 🧠 Use Case:
 * - The most efficient and widely used method in production.
 * - Best for single-threaded applications.
 *
 * ⚡ Benefit:
 * - Built-in method, mutable sequence, in-place reversal.
 * - Very fast and memory-efficient.
 *
 * ⚠️ Drawback:
 * - Not thread-safe (unlike StringBuffer).
 *
 * ⏱️ Time Complexity: O(n)
 * 💾 Space Complexity: O(n)
 */
class StrReverseByStrBuilder implements StringReverse {

    @Override
    public void makeReverseStr(String str) {
        System.out.println(new StringBuilder(str).reverse().toString());
    }
}

/**
 * ⏱️ Time Complexity → O(n)
 * 💾 Space Complexity → O(1)
 */

class StrReverseValueSwap implements StringReverse{

    @Override
    public void makeReverseStr(String str) {
        char[] charArr = str.toCharArray();
        int left = 0;
        int right = str.length() - 1;
        while (left < right){
            char temp = charArr[left];
            charArr[left] = charArr[right];
            charArr[right] = temp;

            left++;
            right--;

        }

        String reverse = new String(charArr);
        System.out.println(reverse);
    }
}

/**
 * 🚀 Main Driver Class
 *
 * Demonstrates all 8 approaches to reverse a string "Shivam"
 * with their outputs.
 */
public class Java_1_StringReversal {

    public static void main(String[] args) {

        System.out.println("➡️  Using StringBuilder:");
        new StrReverseByStrBuilder().makeReverseStr("Shivam");

        System.out.println("\n➡️  Using For Loop:");
        new StrReverseCharLoop().makeReverseStr("Shivam");

        System.out.println("\n➡️  Using StringBuffer:");
        new StrReverseStringBuffer().makeReverseStr("Shivam");

        System.out.println("\n➡️  Using Character Array:");
        new StrReverseCharArray().makeReverseStr("Shivam");

        System.out.println("\n➡️  Using Recursion:");
        new StrReverseRecursion().makeReverseStr("Shivam");

        System.out.println("\n➡️  Using Stack (LIFO):");
        new StrReverseStackLIFO().makeReverseStr("Shivam");

        System.out.println("\n➡️  Using Collections + Stream API:");
        new StrReverseCollectionAPIStream().makeReverseStr("Shivam");

        System.out.println("\n➡️  Using Swap + Char Array:");
        new StrReverseValueSwap().makeReverseStr("Shivam");
    }

}
