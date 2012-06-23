package com.gugugua.algorithms;

import junit.framework.TestCase;

import org.junit.Test;

/**
 * @author cairne huangyihua@diandian.com
 * @date 2012-6-22
 */
public class SearchEntryTest extends TestCase {

    @Test
    public void testCreate() {
        SearchEntry<Integer, Object> searchEntryA = new SearchEntry<Integer, Object>(1, "s");
        SearchEntry<Integer, Object> searchEntryB = new SearchEntry<Integer, Object>(1, "s");
        assertEquals(searchEntryA, searchEntryB);
    }

    /**
     * 
     */
    public void testa() {
        System.out.println(hash(11));
        System.out.println(11 >>> 1);
        System.out.println(hash(1100));
    }

    static int hash(int h) {
        // This function ensures that hashCodes that differ only by
        // constant multiples at each bit position have a bounded
        // number of collisions (approximately 8 at default load factor).
        h ^= (h >>> 20) ^ (h >>> 12);
        return h ^ (h >>> 7) ^ (h >>> 4);
    }
}
