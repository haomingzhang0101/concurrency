package com.haoming.concurrency.example.singleton;

import com.haoming.concurrency.annotations.NotRecommend;
import com.haoming.concurrency.annotations.NotThreadSafe;
import com.haoming.concurrency.annotations.ThreadSafe;

@NotThreadSafe
public class SingletonExample4 {

    // Private constructor
    private SingletonExample4() {

    }

    // 1. memory = allocate()
    // 2. ctorInstance()
    // 3. instance = memory

    // Reorder instructions
    // 1. 3. 2.

    // Singleton object
    private static SingletonExample4 instance = null;

    // Static factory method
    public static SingletonExample4 getInstance() {
        if (instance == null) { // Double check + lock  // B
            synchronized (SingletonExample4.class){
                if (instance == null) {
                    instance = new SingletonExample4(); // A - 3
                }
            }
        }
        return instance;
    }
}
