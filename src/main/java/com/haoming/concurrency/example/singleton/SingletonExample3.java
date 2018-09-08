package com.haoming.concurrency.example.singleton;

import com.haoming.concurrency.annotations.NotRecommend;
import com.haoming.concurrency.annotations.ThreadSafe;

@ThreadSafe
@NotRecommend
public class SingletonExample3 {

    // Private constructor
    private SingletonExample3() {

    }

    // Singleton object
    private static SingletonExample3 instance = null;

    // Static factory method
    public static synchronized SingletonExample3 getInstance() {
        if (instance == null) {
            instance = new SingletonExample3();
            } // Low performance.
        return instance;
    }
}
