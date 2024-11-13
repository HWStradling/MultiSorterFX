package com.backend.multisorterfx.statics;

import java.util.Random;

public class UnsortedArray {
    public static int[] getUnsortedArray(int listLength, int intRange) {
        int[] unsortedList = new int[listLength];
        Random rand = new Random();
        for (int i = 0; i < unsortedList.length; i++) {
            unsortedList[i] = rand.nextInt(intRange);
        }
        return unsortedList;
    }
}
