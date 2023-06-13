package com.dsa.problems;

import java.util.*;
public class MinStack {

    static Stack<Integer> stack;
    static Stack<Integer> min;

    public MinStack() {
        stack=new Stack<>();
        min=new Stack<>();
    }

    public void push(int x) {
        if (!min.isEmpty() && x<=min.peek()){
            min.push(x);
        }
        else if(min.isEmpty()) {
            min.push(x);
        }
        stack.push(x);
    }

    public void pop() {
        if(min.peek() == stack.peek()) {
            min.pop();
        }
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min.peek();
    }

    public static void main(String[] args)
    {
        MinStack mStack = new MinStack();
        mStack.push(1);
        mStack.push(7);
        mStack.push(4);
        mStack.push(0);
        mStack.push(-2);
        mStack.push(3);
        mStack.getMin();
        System.out.println("Min val : "+ mStack.getMin());
        mStack.pop();
        mStack.pop();
        mStack.getMin();
        System.out.println("Min val : "+ mStack.getMin());
        mStack.top();
        System.out.println("Top : "+ mStack.top());
    }
}
