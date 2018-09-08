package com.haoming.concurrency.example.singleton;

import com.haoming.concurrency.annotations.NotThreadSafe;

@NotThreadSafe
public class SingletonExample1 {

    // Private constructor
    private SingletonExample1() {

    }

    // Singleton object
    private static SingletonExample1 instance = null;

    // Static factory method
    public static SingletonExample1 getInstance() {
        if (instance == null) {
            instance = new SingletonExample1();
        } // Not thread-safe, because the constructor could be initialized multiple times.
        return instance;
    }
}
