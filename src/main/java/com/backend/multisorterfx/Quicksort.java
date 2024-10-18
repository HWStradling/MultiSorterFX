package com.backend.multisorterfx;

import java.util.Random;

public class Quicksort {
    public void quickSort(int[] sortingList, int low, int high) {
        if (low >= high) {
            return;
        }
        int pIndex = new Random().nextInt(low,high);
        int pivot = sortingList[pIndex];
        swap(sortingList,pIndex , high);
        int convergedIndex = partition(sortingList, low, high, pivot);
        quickSort(sortingList, low, convergedIndex - 1);
        quickSort(sortingList, convergedIndex + 1, high);
    }
    private int partition(int[] array, int low, int high, int pivot) {
        int leftIndex = low;
        int rightIndex = high - 1;
        while (leftIndex < rightIndex) {
            while (array[leftIndex] <= pivot && leftIndex < rightIndex) {
                leftIndex++;
            }
            while (array[rightIndex] >= pivot && leftIndex < rightIndex) {
                rightIndex--;
            }
            swap(array, leftIndex, rightIndex);
        }
        int convergenceIndex = leftIndex;
        if(array[convergenceIndex] > array[high]) {
            swap(array, convergenceIndex, high);
        }
        else {
            convergenceIndex = high;
        }

        return convergenceIndex;
    }
    private void swap(int[] array, int swapIndex1, int swapIndex2) {
        int temp = array[swapIndex1];
        array[swapIndex1] = array[swapIndex2];
        array[swapIndex2] = temp;
    }
}
