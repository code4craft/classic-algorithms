package com.gugugua.algorithms.trees;

import java.util.List;

import com.gugugua.algorithms.SearchEntry;

/**
 * @author cairne huangyihua@diandian.com
 * @date 2012-6-22
 */
public interface SearchTreeNode<K extends Comparable<K>, V> {

    public SearchEntry<K, V> getEntry();

    public SearchTreeNode<K, V> getParent();

    public boolean hasParent();

    public boolean hasChildren();

    public List<SearchTreeNode<K, V>> getChildren();

}
