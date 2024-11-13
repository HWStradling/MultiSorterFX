package com.backend.multisorterfx;

import com.backend.multisorterfx.statics.SortedArray;
import com.backend.multisorterfx.statics.UnsortedArray;

import java.util.Random;

public class Quicksort extends SortingAlgorithm {

    @Override
    public void callSort(){
        SortedArray.acquireSortingLock();
        try {
            sortingArray = SortedArray.getSortedArray();
            print();
            sort(0, sortingArray.length - 1);
            print();
        }
        catch (NullPointerException e){
            SortedArray.setSortedArray(UnsortedArray.getUnsortedArray());
            sortingArray = SortedArray.getSortedArray();
            print();
            sort(0, sortingArray.length - 1);
            print();
        }
        finally {
            SortedArray.releaseSortingLock();
        }
    }
    protected void sort(int low, int high) {
        if (low >= high) {
            return;
        }
        int pIndex = new Random().nextInt(low,high);
        int pivot = sortingArray[pIndex];
        swap(pIndex , high);
        int convergedIndex = partition(low, high, pivot);
        sort(low, convergedIndex - 1);
        sort(convergedIndex + 1, high);
    }
    private int partition(int low, int high, int pivot) {
        int leftIndex = low;
        int rightIndex = high - 1;
        while (leftIndex < rightIndex) {
            while (sortingArray[leftIndex] <= pivot && leftIndex < rightIndex) {
                leftIndex++;
            }
            while (sortingArray[rightIndex] >= pivot && leftIndex < rightIndex) {
                rightIndex--;
            }
            swap(leftIndex, rightIndex);
        }
        int convergenceIndex = leftIndex;
        if(sortingArray[convergenceIndex] > sortingArray[high]) {
            swap(convergenceIndex, high);
        }
        else {
            convergenceIndex = high;
        }

        return convergenceIndex;
    }
}
