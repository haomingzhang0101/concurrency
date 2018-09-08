package com.haoming.concurrency.example.singleton;

import com.haoming.concurrency.annotations.Recommend;
import com.haoming.concurrency.annotations.ThreadSafe;

@ThreadSafe
@Recommend
public class SingletonExample7 {

    // Private constructor
    private SingletonExample7() {

    }

    public static SingletonExample7 getInstance() {
        return Singleton.INSTANCE.getInstance();
    }

    private enum Singleton {
        INSTANCE;

        private SingletonExample7 singleton;

        // JVM will ensure that this method will only be called once.
        // Instance will only be initialized when get called.
        Singleton() {
            singleton = new SingletonExample7();
        }

        public SingletonExample7 getInstance() {
            return singleton;
        }
    }

}
