package com.gugugua.algorithms.trees;

import junit.framework.TestCase;

import org.junit.Test;

import com.gugugua.algorithms.PerformanceTimer;
import com.gugugua.algorithms.SearchEntry;
import com.gugugua.algorithms.tools.TreeDepthCaculator;

/**
 * @author cairne huangyihua@diandian.com
 * @date 2012-6-22
 */
public class BinarySearchTreeTest extends TestCase {

    @Test
    public void testAdd() {
        PerformanceTimer timer = new PerformanceTimer();
        timer.reset();
        BinarySearchTree<Integer, String> binarySearchTree = new BinarySearchTree<>();
        for (int i = 0; i < 10000; i++) {
            binarySearchTree.add(new SearchEntry<Integer, String>(i, String.valueOf(i)));
        }
        TreeDepthCaculator depthCaculator = new TreeDepthCaculator();
        System.out.println(depthCaculator.calcDepth(binarySearchTree));
        timer.print();

    }

}
