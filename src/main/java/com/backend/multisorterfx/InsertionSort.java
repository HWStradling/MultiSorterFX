package com.backend.multisorterfx;

import com.backend.multisorterfx.statics.SortedArray;

public class InsertionSort extends SortingAlgorithm {
    @Override
    protected void sort(){
        try {
            for (int i = 0; i < sortingArray.length; i++){
                int x = i;
                while (x > 0 && sortingArray[x] < sortingArray[x-1]){
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
