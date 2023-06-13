package com.dsa.problems;

import java.util.Stack;


public class SortStack {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(5);
        stack.push(1);
        stack.push(6);
        stack.push(7);
        stack.push(3);

        SortStack o = new SortStack();
        System.out.println(stack);
        o.sortStack(stack);
        System.out.println(stack);
    }


    public Stack<Integer> sortStack(Stack<Integer> stack) {
        if(stack.isEmpty())
            return stack;

        int pop = stack.pop();
        sortStack(stack);
        insertBottom(stack , pop);

        return stack;
    }

    private void insertBottom(Stack<Integer> stack, int val) {
        if(stack.isEmpty() || stack.peek() < val) {
            stack.push(val);
            return;
        }

        int pop = stack.pop();
        insertBottom(stack, val);
        stack.push(pop);
    }
}
