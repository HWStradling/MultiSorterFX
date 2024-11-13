package com.backend.multisorterfx;

public class InsertionSort extends SortingAlgorithm {

    @Override
    public void sort(int[] sortingList) {
        this.sortingList = sortingList;
        print();
        insertionSort();
        print();
    }
    public void insertionSort(){
        try {
            for (int i = 0; i < sortingList.length; i++){
                int x = i;
                while (x > 0 && sortingList[x] < sortingList[x-1]){
                    swap(x, x-1);
                    x--;
                }
            }
        } catch (NullPointerException e){
            System.out.printf("array error");
            throw new RuntimeException(e);
        }
    }
}
