package com.haoming.concurrency.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

@Slf4j
public class SemaphoreExample2 {

    private final static int threadCount = 20;

    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newCachedThreadPool();

        final Semaphore semaphore = new Semaphore(3);

        for (int i = 0; i < threadCount; i++) {
           final int threadNum = i;
           executorService.execute(() -> {
               try {
                   semaphore.acquire(3); // Getting 3 permits.
                   test(threadNum);
                   semaphore.release(3); // Releasing 3 permits.
               } catch (InterruptedException e) {
                   log.error("Exception", e);
               }
           });
        }
        executorService.shutdown();
    }

    private static void test(int threadNum) throws InterruptedException {
        log.info("{}", threadNum);
        Thread.sleep(1000);
    }
}
