package com.haoming.concurrency.example.singleton;

import com.haoming.concurrency.annotations.ThreadSafe;

@ThreadSafe
public class SingletonExample6 {

    // Private constructor
    private SingletonExample6() {

    }

    // Singleton object
    // Could cause bad performance if too many things to do in the constructor.
    private static SingletonExample6 instance = null;

    static {
        instance = new SingletonExample6();
    }

    // Static factory method
    public static SingletonExample6 getInstance() {
        return instance;
    }

    public static void main(String[] args)  {
        System.out.println(getInstance().hashCode());
        System.out.println(getInstance().hashCode());
    }
}
