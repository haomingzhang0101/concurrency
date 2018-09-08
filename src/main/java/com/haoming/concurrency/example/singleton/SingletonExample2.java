package com.haoming.concurrency.example.singleton;

import com.haoming.concurrency.annotations.ThreadSafe;

@ThreadSafe
public class SingletonExample2 {

    // Private constructor
    private SingletonExample2() {

    }

    // Singleton object
    // Could cause bad performance if too many things to do in the constructor.
    private static SingletonExample2 instance = new SingletonExample2();

    // Static factory method
    public static SingletonExample2 getInstance() {
        return instance;
    }
}
