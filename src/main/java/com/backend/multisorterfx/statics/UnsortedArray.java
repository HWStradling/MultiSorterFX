package com.backend.multisorterfx.statics;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

public class UnsortedArray {

    private static int[] unsortedArray;
    private static final ReentrantLock lock = new ReentrantLock();

    public static void setUnsortedArray(int arrayLength, int intRange) {
        lock.lock();
        try {
            int[] array = new int[arrayLength];
            Random rand = new Random();
            for (int i = 0; i < array.length; i++) {
                array[i] = rand.nextInt(intRange);
            }
            unsortedArray = array;
        } finally {
            lock.unlock();
        }
    }

    public static int[] getUnsortedArray() {
        lock.lock();
        try {
            if (unsortedArray == null) {
                setUnsortedArray();
            }
            return unsortedArray;
        } finally {
            lock.unlock();
        }
    }
    private synchronized static void setUnsortedArray() { // internal default set using synchronized block instead of locks.
        int[] array = new int[10];
        Random rand = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(100);
        }
        unsortedArray = array;
    }

}