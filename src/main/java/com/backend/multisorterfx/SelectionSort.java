package com.backend.multisorterfx;

public class SelectionSort extends SortingAlgorithm{
    @Override
    public void sort(int[] sortingList) {
        this.sortingList = sortingList;
        print();
        selectionsort();
        print();
    }

    private void selectionsort() {


        for (int x = 0; x < sortingList.length - 1; x++) {
            int currentMinimum = x;
            for (int i = x + 1; i < sortingList.length ; i++) { // starts comparison after sorted partition.
                if (sortingList[i] < sortingList[currentMinimum]){
                    currentMinimum = i;
                }
            }
            if (currentMinimum != x){ //if current minimum != original current minimum
                swap(currentMinimum, x);
            }
        }
    }
}
