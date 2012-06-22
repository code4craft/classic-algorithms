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
}
