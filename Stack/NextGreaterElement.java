package com.dsa.problems;

import java.util.*;
public class NextGreaterElement {

    public static void main(String[] args) {
        int[] input = { 7,11,6,3,2,8 };
        System.out.println("output : "+ Arrays.toString(input));
        findNextGrtElement(input);
    }

    public static void findNextGrtElement(int[] in) {
        int[] outArr = new int[in.length];
        Stack<Integer> s = new Stack<>();

        for(int i=in.length-1; i>=0; i-- ){
            if(s.isEmpty()) {
                s.push(in[i]);
                outArr[i] = -1;
            }
            else {
                while (!s.isEmpty() && in[i] > s.peek()){
                    s.pop();
                }
                if(!s.isEmpty())
                    outArr[i] = s.peek();
                else
                    outArr[i] = -1;
                s.push(in[i]);

            }
        }
        System.out.println("output : "+ Arrays.toString(outArr));
    }
}
