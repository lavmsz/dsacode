package com.dsa.problems.sorting;

public class BubbleSort {
    public static void main(String args[])
    {
        int arr[] = { 12, 11, 13, 5, 6 };
        BubbleSort ob = new BubbleSort();
        ob.sort(arr);
        ob.printArray(arr);
    }
    void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
    }
    void sort(int arr[])
    {
        for(int i=0;i<arr.length - 1 ;i++){
            for(int j=0;j<arr.length - i -1 ;j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
}
