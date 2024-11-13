package com.backend.multisorterfx.statics;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SortedArray {
    private static int[] sortedArray;
    private static final ReentrantLock lock = new ReentrantLock();
    private static final ReentrantLock sortLock = new ReentrantLock(true);
    public  void setSortedArray() {
        awaitSortLock();
        lock.lock();
        try{
            int[] array = UnsortedArray.getUnsortedArray();
            if (array == null){
                //todo notification to user.
                return;
            }
            sortedArray = Arrays.copyOf(array, array.length);
        } finally {
            lock.unlock();
        }
    }

    public static synchronized int[] getSortedArray() {
        awaitSortLock();
        lock.lock();
        try{
            return sortedArray;

        }finally {
            lock.unlock();
        }
    }
    public static int getSortedArrayLength() {
        awaitSortLock();
        lock.lock();
        try{
            return sortedArray.length;
        }finally {
            lock.unlock();
        }
    }
    private static void awaitSortLock(){
        while (sortLock.isLocked() && !sortLock.isHeldByCurrentThread()){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public static void acquireSortingLock(){
        sortLock.lock();
    }
    public static void releaseSortingLock(){
        sortLock.unlock();
    }
}
