package com.backend.multisorterfx;

import com.backend.multisorterfx.statics.SortedArray;

public class SelectionSort extends SortingAlgorithm{
    @Override
    public void sort() {
        SortedArray.acquireSortingLock();
        try {
            sortingArray = SortedArray.getSortedArray();
            print();
            selectionsort();
            print();
        } finally {
            SortedArray.releaseSortingLock();
        }
    }

    private void selectionsort() {


        for (int x = 0; x < sortingArray.length - 1; x++) {
            int currentMinimum = x;
            for (int i = x + 1; i < sortingArray.length ; i++) { // starts comparison after sorted partition.
                if (sortingArray[i] < sortingArray[currentMinimum]){
                    currentMinimum = i;
                }
            }
            if (currentMinimum != x){ //if current minimum != original current minimum
                swap(currentMinimum, x);
            }
        }
    }
}
