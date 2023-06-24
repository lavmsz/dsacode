package com.dsa.problems.stack;

import java.util.*;
public class MaxFreqStack {
    static Map<Integer, Integer> freqMap = new HashMap<>();
    static Map<Integer, Stack<Integer> > freqStack = new HashMap<>();
    static int maxfreq = 0;

    public static void main(String[] args) {
        push(5);
        push(7);
        push(5);
        push(7);
        push(4);
        push(5);

        System.out.println(" max freq " + pop());
        System.out.println(" max freq " + pop());
        System.out.println(" max freq " + pop());
        System.out.println(" max freq " + pop());
    }

    public static void push(int x)
    {
        int freq = freqMap.getOrDefault(x,0) + 1;
        freqMap.put(x,freq);

        if (freq > maxfreq)
            maxfreq = freq;
        freqStack.computeIfAbsent(freq, f-> new Stack<>()).push(x);
    }

    public static int pop()
    {
        int max = freqStack.get(maxfreq).pop();
        freqMap.put(max,freqMap.get(max)-1);

        if(freqStack.get(maxfreq).size() == 0){
            maxfreq --;
        }
        return max;
    }
}
