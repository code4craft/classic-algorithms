package com.gugugua.algorithms.trees;


/**
 * @author cairne huangyihua@diandian.com
 * @date 2012-6-22
 */
public class RedBlackSearchTreeTest extends BinarySearchTreeTest {

    public void testPerformace() {
        RedBlackTree<Integer, String> binarySearchTree = new RedBlackTree<>();
        _testPerformance(binarySearchTree);

    }

}
