package com.gugugua.algorithms.trees;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.junit.Test;

/**
 * @author cairne huangyihua@diandian.com
 * @date 2012-6-23
 */
public class TrieTreeTest extends TestCase {

    private List<String> testStrings;

    @Override
    public void setUp() {
        testStrings = new ArrayList<>();
        testStrings.add("asdasd");
        testStrings.add("asswas");
        testStrings.add("vasda");
        testStrings.add("   ");
        testStrings.add("我是");
    }

    @Test
    public void testAdd() {
        TrieTree trieTree = new TrieTree();
        for (String testString : testStrings) {
            trieTree.addWord(testString);
        }
        TrieTreeViewer.outputToConsole(trieTree);
        System.out.println(trieTree.search("a"));
        System.out.println(trieTree.search("as"));
        System.out.println(trieTree.search("我是"));
        System.out.println(trieTree.search("我是a"));
    }

}
