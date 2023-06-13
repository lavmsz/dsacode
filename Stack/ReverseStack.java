package com.dsa.problems;

import java.util.Stack;


public class ReverseStack {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(2);
        stack.push(1);


        ReverseStack o = new ReverseStack();
        System.out.println(stack);
        o.reverseStack(stack);
        System.out.println(stack);
    }


    public Stack<Integer> reverseStack(Stack<Integer> stack) {
        if(stack.isEmpty())
            return stack;

        int pop = stack.pop();
        reverseStack(stack);
        insertBottom(stack , pop);

        return stack;
    }

    private void insertBottom(Stack<Integer> stack, int val) {
        if(stack.isEmpty()) {
            stack.push(val);
            return;
        }

        int pop = stack.pop();
        insertBottom(stack, val);
        stack.push(pop);
    }
}
