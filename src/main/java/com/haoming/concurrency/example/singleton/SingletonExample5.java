package com.haoming.concurrency.example.singleton;

import com.haoming.concurrency.annotations.ThreadSafe;

@ThreadSafe
public class SingletonExample5 {

    // Private constructor
    private SingletonExample5() {

    }

    // 1. memory = allocate()
    // 2. ctorInstance()
    // 3. instance = memory

    // Singleton object volatile + Double check
    private volatile static SingletonExample5 instance = null;

    // Static factory method
    public static SingletonExample5 getInstance() {
        if (instance == null) { // Double check + lock
            synchronized (SingletonExample5.class){
                if (instance == null) {
                    instance = new SingletonExample5();
                }
            }
        }
        return instance;
    }
}
