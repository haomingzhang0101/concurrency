package com.haoming.concurrency.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class CountDownLatchExample2 {

    private final static int threadCount = 200;

    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newCachedThreadPool();

        final CountDownLatch countDownLatch = new CountDownLatch(threadCount);

        for (int i = 0; i < threadCount; i++) {
           final int threadNum = i;
//           Thread.sleep(1);
           executorService.execute(() -> {
               try {
                   test(threadNum);
               } catch (InterruptedException e) {
                   log.error("Exception", e);
               } finally {
                   countDownLatch.countDown();
               }
           });
        }
        countDownLatch.await(10, TimeUnit.MILLISECONDS);
        log.info("Done.");
        executorService.shutdown();
    }

    private static void test(int threadNum) throws InterruptedException {
        Thread.sleep(100);
        log.info("{}", threadNum);
    }
}
