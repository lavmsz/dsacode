package com.dsa.problems.stack;

import java.util.Stack;
public class Histogram {

    public static void main(String[] args) {
        int[] arr1 = {6,4,6,5,8,3};
        int[] arr2 = {2,1,5,6,2,3};

        Histogram o = new Histogram();
        int area1= o.findArea(arr1);
        int area2 = o.findArea(arr2);
        System.out.println(area1);
        System.out.println(area2);
    }

    private int findArea(int[] arr) {
        int area = 0;
        int maxArea = 0;
        Stack<Integer> st = new Stack<>();
        for(int i=0; i< arr.length; i++){
            while(!st.isEmpty() && arr[st.peek()] > arr[i]){
               int height = st.pop();
               int left = !st.isEmpty() ? st.peek() : -1;
               area = arr[height] * (i-left-1);
               maxArea = Math.max(area,maxArea);
            }
            st.push(i);
        }
        return maxArea;
    }
}
