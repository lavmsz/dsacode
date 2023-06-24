package com.dsa.problems.queue;

import java.util.*;
public class StackUsingQueue {

    static Queue<Integer> q1 = new LinkedList<Integer>();
    static Queue<Integer> q2 = new LinkedList<Integer>();

    public static void main(String[] args)
    {
        StackUsingQueue s = new StackUsingQueue();
        s.push(5);
        s.push(7);
        s.push(11);
        s.push(1);
        System.out.println("initial size: " + s.size());
        System.out.println(s.top());
        s.pop();
        System.out.println(s.top());
        s.pop();
        System.out.println(s.top());
        System.out.println("current size: " + s.size());
    }
    static void push(int x)
    {
        q2.add(x);
        while (!q1.isEmpty()) {
            q2.add(q1.peek());
            q1.remove();
        }
        Queue<Integer> q = q1;
        q1 = q2;
        q2 = q;
    }
    static void pop()
    {
        if (q1.isEmpty())
            return;
        q1.remove();
    }
    static int top()
    {
        if (q1.isEmpty())
            return -1;
        return q1.peek();
    }
    static int size() {
        return q1.size();
    }
}
