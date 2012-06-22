package com.gugugua.algorithms.trees;

import java.util.List;

import com.gugugua.algorithms.SearchEntry;

/**
 * @author cairne huangyihua@diandian.com
 * @date 2012-6-22
 */
interface SearchTreeNode<K extends Comparable<K>, V> {

    SearchEntry<K, V> getEntry();

    SearchTreeNode<K, V> getParent();

    boolean hasParent();

    boolean hasChildren();

    List<SearchTreeNode<K, V>> getChildren();

}
