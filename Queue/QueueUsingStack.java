package com.dsa.problems.queue;

import java.util.*;

class QueueUsingStack {
    Stack < Integer > stack1 = new Stack <>();
    Stack < Integer > stack2 = new Stack <>();


    /** Push element x to the back of queue. */
    public void push(int x) {
        stack1.push(x);
        System.out.println("push " + x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        // shift input to output
        if (stack2.isEmpty()) {
            System.out.println("Stack2 is empty");
            while(!stack1.isEmpty()) {
                stack2.push(stack1.peek());
                stack1.pop();
            }
        }
        int val = stack2.peek();
        stack2.pop();
        return val;

    }

    /** Get the front element. */
    public int peek() {
        // shift input to output
        if (stack2.isEmpty()) {
            System.out.println("Stack is empty");
            while(!stack1.isEmpty()) {
                stack2.push(stack1.peek());
                stack1.pop();
            }

        }
        return stack2.peek();
    }


    int size() {
        return (stack1.size() + stack2.size());
    }


    public static void main(String args[]) {
        QueueUsingStack q = new QueueUsingStack();
        q.push(3);
        q.push(4);
        q.push(7);
        System.out.println("pop : " + q.pop());
        q.push(5);
        System.out.println("top" + q.peek());
        System.out.println("size " + q.size());

    }
}
