package com.backend.multisorterfx.singletons;

import java.util.concurrent.ConcurrentLinkedQueue;

public class SingletonNotificationQueue {
    private final ConcurrentLinkedQueue<String> notificationQueue = new ConcurrentLinkedQueue<String>();
    private static final SingletonNotificationQueue Instance = new SingletonNotificationQueue();

    private SingletonNotificationQueue (){
        if (Instance != null){
            throw new IllegalStateException("Singleton already instantiated");
        }
    }

    public static SingletonNotificationQueue getInstance(){
        return Instance;
    }

    public boolean isEmpty(){
        return notificationQueue.isEmpty();
    }

    public String getNextNotification(){
        return notificationQueue.poll();
    }

    public void addNotification(String newNotification){
        notificationQueue.add(newNotification);
    }
}
