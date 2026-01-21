package Day5_DSA.Homework5;

import java.util.Arrays;
import java.util.Stack;

public class ReverseStringByStack {
    public static String reverseWords(String input) {
        Stack<String> wStack = new Stack<>();

        String[] words = input.split(" ");

        // Push từng từ vào stack
        for (String word : words) {
            wStack.push(word);
        }

        // Pop ra và nối lại
        StringBuilder output = new StringBuilder();
        while (!wStack.isEmpty()) {
            output.append(wStack.pop());
            if (!wStack.isEmpty()) {
                output.append(" ");
            }
        }
        return output.toString();
    }

    public static void main(String[] args) {
        String str = "Hello World";

        System.out.println("Chuỗi ban đầu: " + str);
        System.out.println("Chuỗi sau khi đảo: " + reverseWords(str));
    }
}