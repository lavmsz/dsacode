package com.dsa.problems.sorting;

public class InsertionSort {

    public static void main(String args[])
    {
        int arr[] = { 12, 11, 13, 5, 6 };
        InsertionSort ob = new InsertionSort();
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
        for(int i=1;i<arr.length;i++){
            int j = i-1;
            int temp = arr[i];
            while(j>=0 && arr[j] > arr[j+1]){
                arr[j+1] = arr[j];
                arr[j] = temp;
                j--;
            }
        }
    }
}
