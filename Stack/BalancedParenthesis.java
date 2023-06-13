package com.dsa.problems;

import java.util.Stack;

public class BalancedParenthesis {

    public static void main(String[] args) {
        BalancedParenthesis b = new BalancedParenthesis();
        String input = "}()[]{";
        boolean result = b.isValidSwitch(input);
        System.out.println(input + " ::  " + result);
    }


    public Boolean isValidSwitch(String brackets) {
        Stack<Character> stack = new Stack<>();
        char[] chars = brackets.toCharArray();
        for (char c : chars) {
            switch (c){
                case '(':
                case '{':
                case '[':
                    stack.push(c);
                    break;
                case ')':
                    if (stack.isEmpty() || stack.pop() != '(')
                        return false;
                case '}':
                    if (stack.isEmpty() || stack.pop() != '{')
                        return false;
                case ']':
                    if (stack.isEmpty() || stack.pop() != '[')
                        return false;
            }
        }
        return stack.isEmpty();
    }

}
