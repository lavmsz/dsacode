package com.dsa.problems.stack;

import java.util.*;
public class OnlineStockSpan {
    public static void main(String[] args) {
        int[] arr1 = {100, 80, 60, 70, 60 ,75 ,85};
        int[] arr2 = {7,34,10,2,8};

        int[] result = stockSpan(arr1);
        System.out.println(Arrays.toString(result));
    }
    public static int[] stockSpan(int[] arr) {
        if (arr == null || arr.length == 0) {
            return new int[0];
        }
        int[] result = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[i] > arr[stack.peek()]) {
                stack.pop();
            }
            int len = i - (stack.isEmpty() ? -1 : stack.peek());
            stack.push(i);
            result[i] = len;
        }
        return result;
    }
}
