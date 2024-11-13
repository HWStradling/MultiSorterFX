package com.backend.multisorterfx;

import java.util.Arrays;

public abstract class SortingAlgorithm {

    protected int[] sortingList;

    public abstract void sort(int[] sortingList);

    protected void print() {
        System.out.println(this.getClass().getSimpleName() + Arrays.toString(sortingList));
    }

    protected void swap(int swapIndex1, int swapIndex2) {
        int temp = sortingList[swapIndex1];
        sortingList[swapIndex1] = sortingList[swapIndex2];
        sortingList[swapIndex2] = temp;
    }
}


