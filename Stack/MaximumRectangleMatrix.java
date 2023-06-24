package com.dsa.problems.stack;

import java.util.Stack;
class MaximumRectangleMatrix {

    public static void main(String[] args) {
        char[][] matrix = {{'1','0','1','0','0'}, {'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        int area = maxRectangle(matrix);
        System.out.println("final :: " + area);
    }
    public static int maxRectangle(char[][] matrix) {
        if(matrix.length == 0)  return 0;
        int maxArea = 0;
        int row = matrix.length;
        int col = matrix[0].length;
        int[] dp = new int[col];
        for(int i=0;i<row;i++){
            System.out.println("for row : " + i + "=========================");
            for(int j=0;j<col;j++){
                System.out.println("matrix[i][j] ^^^^^ " + matrix[i][j]);
                dp[j] = matrix[i][j] == '1' ? dp[j]+1 : 0;
                System.out.println("dp[ " +j + "] : " + dp[j]);
            }
            maxArea = Math.max(maxArea, findMaxArea(dp));
            System.out.println("maxArea row  : " + i + " - " + maxArea);
        }
        return maxArea;
    }

    public static int findMaxArea(int[] dp){
        int len = dp.length;
        int maxArea = 0;
        int[] left = new int[len];
        int[] right = new int[len];
        Stack<Integer> stack = new Stack<>();
        //from left to right, to find left limit
        for(int i=0;i<len;i++){
            if(stack.isEmpty()){
                stack.push(i);
                left[i] = 0;
            }else{
                while(!stack.isEmpty() && dp[stack.peek()] >= dp[i])
                    stack.pop();
                left[i] = stack.isEmpty() ? 0 : stack.peek()+1;
                stack.push(i);
            }
        }

        while(!stack.isEmpty())
            stack.pop();

        //from right to left, to find right limit
        for(int i=len-1;i>=0;i--){
            if(stack.isEmpty()){
                stack.push(len-1);
                right[i] = len - 1;
            }else{
                while(!stack.isEmpty() && dp[stack.peek()] >= dp[i])
                    stack.pop();
                right[i] = stack.isEmpty() ? len-1 : stack.peek()-1;
                stack.push(i);
            }
        }
        //traversing the array , calculating area
        int[] area = new int[len];
        for(int i=0;i<len;i++){
            area[i] = (right[i] - left[i] + 1) * dp[i];
            maxArea = Math.max(maxArea, area[i]);
        }
        System.out.println("Area x  - " + maxArea);
        return maxArea;
    }
}
