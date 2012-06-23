package com.gugugua.algorithms.collections;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

import org.junit.Before;
import org.junit.Test;

import com.gugugua.algorithms.PerformanceTimer;

/**
 * @author cairne huangyihua@diandian.com
 * @date 2012-6-23
 */
public class MapBenchmark {

    private int[] seeds;

    private int limit;

    @Before
    public void before() {
        limit = 1000000;
        seeds = new int[limit];
        Random random = new Random();
        for (int i = 0; i < limit; i++) {
            seeds[i] = random.nextInt(limit);
        }
    }

    public void testTreeMap() {
        System.out.println("testTreeMap");
        _testPutAndGet(new TreeMap<Integer, String>());
    }

    @Test
    public void testLinkedhashMap() {
        System.out.println("testLinkedhashMap");
        _testPutAndGet(new LinkedHashMap<Integer, String>());
    }

    @Test
    public void testHashMapWhitInit() {
        System.out.println("testHashMapWhitInit");
        _testPutAndGet(new HashMap<Integer, String>(2000000));
    }

    @Test
    public void testHashMapWhitInit1() {
        System.out.println("testHashMapWhitInit");
        _testPutAndGet(new HashMap<Integer, String>(1000000));
    }

    public void testHashTable() {
        System.out.println("testHashTable");
        _testPutAndGet(new Hashtable<Integer, String>());
    }

    public void testConcurrentHashMap() {
        System.out.println("testConcurrentHashMap");
        _testPutAndGet(new Hashtable<Integer, String>());
    }

    public void testWeakHashMap() {
        System.out.println("testWeakHashMap");
        _testPutAndGet(new Hashtable<Integer, String>());
    }

    @Test
    public void testHashMap() {
        System.out.println("testHashMap");
        _testPutAndGet(new HashMap<Integer, String>());
    }

    public void _testPutAndGet(Map<Integer, String> map) {
        int round = 100;
        PerformanceTimer timerCreate = new PerformanceTimer(round, true);
        PerformanceTimer timerSearch = new PerformanceTimer(round, true);
        //        PerformanceMemory memory = new PerformanceMemory(round, true);

        for (int j = 0; j < round; j++) {
            int limit = 1000000;
            timerCreate.start(j);
            //            memory.start(j);
            for (int i = 0; i < limit; i++) {
                map.put(seeds[i], "");
            }
            timerCreate.end(j);
            //            memory.end(j);
            timerSearch.start(j);
            for (int i = 0; i < limit; i++) {
                map.get(seeds[i]);
            }
            timerSearch.end(j);
        }
        System.out.println("average create " + timerCreate.average(round));
        System.out.println("average search " + timerSearch.average(round));
        //        System.out.println("memory used " + memory.average(round));
    }
}
