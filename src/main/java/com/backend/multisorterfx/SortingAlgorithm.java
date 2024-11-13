package com.backend.multisorterfx;

import com.backend.multisorterfx.statics.SortedArray;
import com.backend.multisorterfx.statics.UnsortedArray;

import java.util.Arrays;

public abstract class SortingAlgorithm {

    protected int[] sortingArray;

    public void callSort(){
        SortedArray.acquireSortingLock();
        try {
            this.sortingArray = SortedArray.getSortedArray();
            print();
            sort();
            print();
        }
        catch (NullPointerException e){
            SortedArray.setSortedArray(UnsortedArray.getUnsortedArray());
            this.sortingArray = SortedArray.getSortedArray();
            print();
            sort();
            print();
        }
        finally {
            SortedArray.releaseSortingLock();
        }
    };

    protected void sort(){};
    protected void print() {
        System.out.println(this.getClass().getSimpleName() + Arrays.toString(sortingArray));
    }

    protected void swap(int swapIndex1, int swapIndex2) {
        int temp = sortingArray[swapIndex1];
        sortingArray[swapIndex1] = sortingArray[swapIndex2];
        sortingArray[swapIndex2] = temp;
    }
}


