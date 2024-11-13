package com.backend.multisorterfx;

import java.util.Random;

public class Quicksort extends SortingAlgorithm {

    @Override
    public void sort(int[] sortingList){
        this.sortingList = sortingList;
        print();
        quickSort(0, sortingList.length - 1);
        print();
    }
    public void quickSort(int low, int high) {
        if (low >= high) {
            return;
        }
        int pIndex = new Random().nextInt(low,high);
        int pivot = sortingList[pIndex];
        swap(pIndex , high);
        int convergedIndex = partition(low, high, pivot);
        quickSort(low, convergedIndex - 1);
        quickSort(convergedIndex + 1, high);
    }
    private int partition(int low, int high, int pivot) {
        int leftIndex = low;
        int rightIndex = high - 1;
        while (leftIndex < rightIndex) {
            while (sortingList[leftIndex] <= pivot && leftIndex < rightIndex) {
                leftIndex++;
            }
            while (sortingList[rightIndex] >= pivot && leftIndex < rightIndex) {
                rightIndex--;
            }
            swap(leftIndex, rightIndex);
        }
        int convergenceIndex = leftIndex;
        if(sortingList[convergenceIndex] > sortingList[high]) {
            swap(convergenceIndex, high);
        }
        else {
            convergenceIndex = high;
        }

        return convergenceIndex;
    }
}
