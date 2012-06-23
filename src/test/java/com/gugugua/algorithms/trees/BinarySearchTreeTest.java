package com.gugugua.algorithms.trees;

import java.util.Comparator;
import java.util.Random;

import junit.framework.TestCase;

import com.gugugua.algorithms.PerformanceTimer;
import com.gugugua.algorithms.SearchEntry;

/**
 * @author cairne huangyihua@diandian.com
 * @date 2012-6-22
 */
public class BinarySearchTreeTest extends TestCase {

    public void testPerformance() {
        System.out.println("binary search tree");
        BinarySearchTree<Integer, String> binarySearchTree = new BinarySearchTree<>();
        _testPerformance(binarySearchTree);
        System.out.println("red black tree");
        binarySearchTree = new RedBlackTree<>();
        _testPerformance(binarySearchTree);
    }

    protected void _testPerformance(BinarySearchTree<Integer, String> binarySearchTree) {
        int round = 10;
        PerformanceTimer timerCreate = new PerformanceTimer(10);
        PerformanceTimer timerSearch = new PerformanceTimer(10);
        for (int j = 0; j < round; j++) {
            Random random = new Random();
            int limit = 1000000;
            timerCreate.start(j);
            for (int i = 0; i < limit; i++) {
                binarySearchTree.add(new SearchEntry<Integer, String>(random.nextInt(limit), String
                        .valueOf(i)));
            }
            timerCreate.end(j);
            binarySearchTree.add(new SearchEntry<Integer, String>(limit / 2, String
                    .valueOf(limit + 1)));
            TreeDepthCaculator depthCaculator = new TreeDepthCaculator();
            System.out.println(depthCaculator.calcDepth(binarySearchTree));
            SearchEntry<Integer, String> searchEntry = binarySearchTree.get(limit / 2);
            assertNotNull(searchEntry);
            timerSearch.start(j);
            for (int i = 0; i < limit; i++) {
                binarySearchTree.get(random.nextInt(limit));
            }
            timerSearch.end(j);
        }
        System.out.println("average create " + timerCreate.average(round));
        System.out.println("average search " + timerSearch.average(round));
    }

    public void _testRotate() {
        for (int j = 0; j < 100; j++) {
            System.out.println("time " + j);
            int limit = 10000;
            BinarySearchTree<Integer, String> binarySearchTree = new BinarySearchTree<>();
            binarySearchTree.root = new BinarySearchTreeNode<Integer, String>(
                    new SearchEntry<Integer, String>(0, String.valueOf(0)));
            Random random = new Random();
            for (int i = 1; i < limit; i++) {
                BinarySearchTreeNode<Integer, String> binarySearchTreeNode = new BinarySearchTreeNode<Integer, String>(
                        new SearchEntry<Integer, String>(random.nextInt(limit), String.valueOf(i)));
                binarySearchTree.insert(binarySearchTree.getRoot(), binarySearchTreeNode);
                binarySearchTree.rotateLeft(binarySearchTreeNode);
                binarySearchTree.rotateLeft(binarySearchTree.root);
                binarySearchTree.rotateRight(binarySearchTreeNode);
                binarySearchTree.get(-1);
                binarySearchTree.get(limit + 1);
            }
        }
        Comparator<String> IPcomparator = new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
                String[] ipSecs1 = o1.split("\\.");
                String[] ipSecs2 = o2.split("\\.");
                if (ipSecs1.length != 4 || ipSecs2.length != 4) {
                    throw new IllegalArgumentException("invalid ip");
                }
                for (int i = 0; i < 4; i++) {
                    try {
                        Integer ipSec1 = Integer.parseInt(ipSecs1[i]);
                        Integer ipSec2 = Integer.parseInt(ipSecs1[i]);
                        int compareTo = ipSec1.compareTo(ipSec2);
                        if (compareTo != 0) {
                            return compareTo;
                        }
                    } catch (NumberFormatException e) {
                        throw new IllegalArgumentException("invalid ip");
                    }
                }
                return 0;
            }

        };
    }
}
