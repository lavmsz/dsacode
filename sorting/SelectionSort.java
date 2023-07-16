package com.dsa.problems.sorting;

public class SelectionSort {

    public static void main(String args[])
    {
        SelectionSort ob = new SelectionSort();
        int arr[] = {64,25,12,22,11};
        ob.sort(arr);
        System.out.println("Sorted array");
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
        for(int i = 0; i<(arr.length) -1 ; i++){
            int min = i;
            for(int j = i+1; j<(arr.length) ;j++){
                if(arr[j] < arr[min] ){
                    min = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
    }
}
