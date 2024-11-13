package com.backend.multisorterfx;

import java.util.Arrays;

public abstract class SortingAlgorithm {

    protected int[] sortingArray;

    public abstract void sort();

    protected void print() {
        System.out.println(this.getClass().getSimpleName() + Arrays.toString(sortingArray));
    }

    protected void swap(int swapIndex1, int swapIndex2) {
        int temp = sortingArray[swapIndex1];
        sortingArray[swapIndex1] = sortingArray[swapIndex2];
        sortingArray[swapIndex2] = temp;
    }
}


