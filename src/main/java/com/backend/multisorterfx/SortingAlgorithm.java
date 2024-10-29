package com.backend.multisorterfx;

import java.util.Arrays;

public abstract class SortingAlgorithm {
    
    int[] sortingList;
    public abstract void sort(int[] sortingList);
    public void print(){
        System.out.println(this.getClass().getSimpleName() +  Arrays.toString(sortingList));
    }
}
