package com.gugugua.algorithms.trees;

/**
 * @author cairne huangyihua@diandian.com
 * @date 2012-6-22
 */
public interface SearchTree<K extends Comparable<K>, V> {

    public SearchTreeNode<K, V> getRoot();

}
