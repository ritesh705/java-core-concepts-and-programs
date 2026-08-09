package com.ritesh.java.concepts.collections;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Logger;

public class CollectionProgram {

    private static final Logger logger = Logger.getLogger(String.valueOf(CollectionProgram.class));
    private static final Map<Integer, String> hashMap = new HashMap<>();
    private static final Map<Integer, String> concurrentHashMap = new ConcurrentHashMap<>();

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            for(int i = 0; i < 500000; i++)
            {
                hashMap.put(i,"value"+i);
                logger.info("Hash Map value: " + hashMap.get(i));
            }
        });
        Thread t2 = new Thread(() -> {
            for(int i = 500001; i < 1000000; i++)
            {
                hashMap.put(i,"value"+i);
                logger.info("Hash Map value: " + hashMap.get(i));
            }
        });
        Thread t3 = new Thread(() -> {
            for(int i = 0; i < 500000; i++)
            {
                concurrentHashMap.put(i,"value"+i);
                logger.info("Concurrent Hash Map value: " + concurrentHashMap.get(i));
            }
        });
        Thread t4 = new Thread(() -> {
            for(int i = 500001; i < 1000000; i++)
            {
                concurrentHashMap.put(i,"value"+i);
                logger.info("Concurrent Hash Map value: " + concurrentHashMap.get(i));
            }
        });
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
