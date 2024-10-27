package com.backend.multisorterfx;

import java.util.Arrays;

public class SortCaller {
    public int[] callQuicksort(int[] array){
        System.out.println(Arrays.toString(array));
        new Quicksort().quickSort(array,0, array.length - 1);
        System.out.println(Arrays.toString(array));
        return array;
    }
    public int[] callInsertionsort(int[] array){
        System.out.println(Arrays.toString(array));
        new InsertionSort().insertionSort(array);
        System.out.println(Arrays.toString(array));
        return array;
    }



}
