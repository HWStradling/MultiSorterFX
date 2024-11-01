package com.backend.multisorterfx;

import java.util.Arrays;

public abstract class SortingAlgorithm {
    
    int[] sortingList;
    public abstract void sort(int[] sortingList);
    public void print(){
        System.out.println(this.getClass().getSimpleName() +  Arrays.toString(sortingList));
    }
    public void swap(int swapIndex1, int swapIndex2) {
        int temp = sortingList[swapIndex1];
        sortingList[swapIndex1] = sortingList[swapIndex2];
        sortingList[swapIndex2] = temp;
    }
}
