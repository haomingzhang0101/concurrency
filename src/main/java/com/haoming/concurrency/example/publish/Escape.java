package com.haoming.concurrency.example.publish;

import com.haoming.concurrency.annotations.NotRecommend;
import com.haoming.concurrency.annotations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@NotThreadSafe
@NotRecommend
public class Escape {

    private int thisCanBeEscaped = 0;

    public Escape() {
        new InnerClass();
    }

    private class InnerClass {

        public InnerClass() {
            log.info("{}", Escape.this.thisCanBeEscaped);
        }
    }

    public static void main(String[] args)  {
        new Escape();
    }
}
