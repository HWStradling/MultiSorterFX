package com.backend.multisorterfx;

import com.backend.multisorterfx.statics.SortedArray;
import com.backend.multisorterfx.statics.UnsortedArray;

public class Mergesort extends SortingAlgorithm {

    @Override
    public void callSort() {
        SortedArray.acquireSortingLock();
        try {
            sortingArray = SortedArray.getSortedArray();
            print();
            sort(sortingArray);
            print();
        }
        catch (NullPointerException e){
            SortedArray.setSortedArray(UnsortedArray.getUnsortedArray());
            sortingArray = SortedArray.getSortedArray();
            print();
            sort(sortingArray);
            print();
        }
        finally {
            SortedArray.releaseSortingLock();
        }
    }

    private void sort(int[] array) {
        int arrayLength = array.length;
        if (arrayLength < 2 ){ // recursive base case.
            return;
        }
        int midpoint = arrayLength/2;
        int[] leftPartition = new int[midpoint];
        int[] rightPartition = new int[arrayLength - midpoint];

        System.arraycopy(array, 0, leftPartition, 0, midpoint); // more efficient than a for loop on large arrays.
        System.arraycopy(array, midpoint, rightPartition, 0, arrayLength - midpoint);

        sort(leftPartition); // recursion.
        sort(rightPartition);

        merge(array, leftPartition, rightPartition); // merging partitions.
    }
    private void merge(int[] array, int[] leftPartition, int[] rightPartition){
        int leftLength = leftPartition.length;
        int rightLength = rightPartition.length;
        int i = 0, j = 0, k = 0; //i: merging array iterator, j left partition iterator, k right partition iterator.
        while (j < leftLength && k < rightLength){
            if (leftPartition[j] <= rightPartition[k]){ // merge left partition value into merge array.
                array[i] = leftPartition[j];
                j++;
            } else { // merge right partition value into merge array.
                array[i] = rightPartition[k];
                k++;
            }
            i++;
        }
        // merges remaining values from left/right partition into the merge array.
        while (j < leftLength){
            array[i] = leftPartition[j];
            j++;
            i++;
        }
        while (k < rightLength){
            array[i] = rightPartition[k];
            k++;
            i++;
        }
    }
}
