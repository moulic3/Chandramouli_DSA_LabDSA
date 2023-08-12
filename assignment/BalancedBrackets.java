package com.dsa.assignment;

import java.util.Stack;

public class BalancedBrackets {

    public  boolean isBalanced(String inputString) {
        Stack<Character> stack = new Stack<>();
        // Array to store the opening brackets
        char[] openingBrackets = {'(', '[', '{'};
        // Array to store the corresponding closing brackets
        char[] closingBrackets = {')', ']', '}'};

        for (char c : inputString.toCharArray()) {
            if (contains(openingBrackets, c)) {
                // If an opening bracket is encountered, push it onto the stack
                stack.push(c);
            } else if (contains(closingBrackets, c)) {
                // If a closing bracket is encountered, check if the stack is empty
                if (stack.isEmpty()) {
                    return false;
                }
                // Get the corresponding opening bracket
                char expectedOpeningBracket = openingBrackets[indexOf(closingBrackets, c)];
                // Pop the top element from the stack
                char topElement = stack.pop();
                // Check if the popped element matches the expected opening bracket
                if (topElement != expectedOpeningBracket) {
                    return false;
                }
            }
        }

        // After processing the entire string, check if the stack is empty
        // If it's empty, all brackets were balanced, otherwise, it's unbalanced
        return stack.isEmpty();
    }

    // Helper method to check if an array contains a specific character
    private static boolean contains(char[] array, char c) {
        for (char ch : array) {
            if (ch == c) {
                return true;
            }
        }
        return false;
    }

    // Helper method to find the index of a specific character in an array
    private static int indexOf(char[] array, char c) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == c) {
                return i;
            }
        }
        return -1;
    }

    
}

