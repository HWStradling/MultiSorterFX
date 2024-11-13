package com.backend.multisorterfx;

public class BubbleSort extends SortingAlgorithm {
    @Override
    public void sort(int[] sortingList) {
        this.sortingList = sortingList;
        print();
        bubblesort();
        print();
    }

    private void bubblesort() {
        boolean sorted = false;
        while (!sorted){
            boolean bubble = false;
            for (int i = 0; i < sortingList.length; i++) {
                if (i == sortingList.length - 1 && !bubble){ //whole iteration with no swaps means is sorted,
                    sorted = true;
                    break;
                } else if (i == sortingList.length - 1) { // reached end of list with swaps
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
        if (sortingList[i] > sortingList[j]){
            return true;
        } else {
            return false;
        }
    }
}
