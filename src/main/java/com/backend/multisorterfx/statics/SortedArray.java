package com.backend.multisorterfx.statics;
import java.util.Arrays;
import java.util.concurrent.locks.ReentrantLock;

public class SortedArray {
    private static int[] sortedArray;
    private static final ReentrantLock lock = new ReentrantLock();
    private static final ReentrantLock sortLock = new ReentrantLock(true);
    public static void setSortedArray(int[] array) {
        awaitSortLock();
        lock.lock();
        try{
            sortedArray = Arrays.copyOf(array, array.length);
        } finally {
            lock.unlock();
        }
    }
    public static int[] getSortedArray() {
        awaitSortLock();
        lock.lock();
        try{
            if (sortedArray == null){
                setSortedArray();
            }
            return sortedArray;
        }finally {
            lock.unlock();
        }
    }
    public static int getSortedArrayLength(){
        awaitSortLock();
        lock.lock();
        try{
            if (sortedArray == null){
                setSortedArray();
            }
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
    public  synchronized static void setSortedArray() {
            int[] array = UnsortedArray.getUnsortedArray();
            sortedArray = Arrays.copyOf(array, array.length);
    }
    public static void acquireSortingLock(){
        sortLock.lock();
    }
    public static void releaseSortingLock(){
        sortLock.unlock();
    }
}
