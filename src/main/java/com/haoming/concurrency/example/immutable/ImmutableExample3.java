package com.haoming.concurrency.example.immutable;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.haoming.concurrency.annotations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@ThreadSafe
public class ImmutableExample3 {

    private final static ImmutableList<Integer> list = ImmutableList.of(1, 2, 3);

    private final static ImmutableSet set = ImmutableSet.copyOf(list);

    private final static ImmutableMap<Integer, Integer> map1 = ImmutableMap.of(1, 2, 3, 4);

    private final static ImmutableMap<Integer, Integer> map2 = ImmutableMap.<Integer, Integer>builder().put(1, 2).put(3, 4).build();

    public static void main(String[] args) {
//        list.add(2);  Deprecated UnsupportedOperationException
//        map1.put(5,6); UnsupportedOperationException
        map1.forEach((k, v) -> System.out.println("map1 " + k + " " + v));
        map2.forEach((k, v) -> System.out.println("map2 " + k + " " + v));
    }
}
