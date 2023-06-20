package com.dsa.problems.stack;
import java.util.Stack;
public class TrapRainWater {

    public static void main(String[] args) {
        int[] arr1 = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        //int[] arr2 = {4, 2, 0, 3, 2, 5};
        int[] arr3 = {1, 5, 4, 0, 2, 3,0,3};
        TrapRainWater o = new TrapRainWater();
        int water1 = o.trapWater(arr1);
        //int water2 = o.trapWater(arr2);
        int water3 = o.trapWater(arr3);
        System.out.println(water1);
        // TrapRainWaterSystem.out.println(water2);
        System.out.println(water3);
    }

    int trapWater(int[] arr) {
        int result = 0;
        Stack<Integer> st = new Stack<>();
        int len = arr.length;
        int in = 0;

        for ( in = 0; in < len; in++) {

            while(! st.isEmpty() && arr[in] >= arr[st.peek()]) {
               int height = st.pop();
                int left = 0 ;

              if(! st.isEmpty())
                    left = st.peek();
               else
                   continue;

               //System.out.println(height + "--> Min(" + arr[in] + arr[left] + ") -" + arr[height] + "*" + in + "-" +left + "-1");
               int l = Math.min(arr[in],arr[left]) - arr[height];
               result += l * (in-left-1);

            }
            st.push(in);

        }
        return result;
    }
}
