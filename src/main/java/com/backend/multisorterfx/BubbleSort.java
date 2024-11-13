package com.backend.multisorterfx;

import com.backend.multisorterfx.statics.SortedArray;

public class BubbleSort extends SortingAlgorithm {
    @Override
    public void sort() {
        SortedArray.acquireSortingLock();
        try {
            sortingArray = SortedArray.getSortedArray();
            print();
            bubblesort();
            print();
        } finally {
            SortedArray.releaseSortingLock();
        }
    }

    private void bubblesort() {
        boolean sorted = false;
        while (!sorted){
            boolean bubble = false;
            for (int i = 0; i < sortingArray.length; i++) {
                if (i == sortingArray.length - 1 && !bubble){ //whole iteration with no swaps means is sorted,
                    sorted = true;
                    break;
                } else if (i == sortingArray.length - 1) { // reached end of list with swaps
                    break;
                }
                if (isGreater(i,i+1)){ // compares values, performs swap if i>j,
                    swap(i,i+1);
                    bubble = true;
                }
            }
        }
    }
    private boolean isGreater(int i, int j){
        if (sortingArray[i] > sortingArray[j]){
            return true;
        } else {
            return false;
        }
    }
}
