package com.gugugua.algorithms.trees;

import java.util.ArrayList;
import java.util.List;

import com.gugugua.algorithms.SearchEntry;

/**
 * @author cairne huangyihua@diandian.com
 * @date 2012-6-22
 */
public class BinarySearchTreeNode<K extends Comparable<K>, V> implements SearchTreeNode<K, V> {

    private final SearchEntry<K, V> entry;

    private BinarySearchTreeNode<K, V> parent;

    private BinarySearchTreeNode<K, V> leftChild;

    private BinarySearchTreeNode<K, V> rightChild;

    /**
     * @param entry
     */
    public BinarySearchTreeNode(SearchEntry<K, V> entry) {
        super();
        this.entry = entry;
    }

    /**
     * @return
     */
    @Override
    public SearchEntry<K, V> getEntry() {
        return entry;
    }

    /**
     * @return
     */
    @Override
    public SearchTreeNode<K, V> getParent() {
        return parent;
    }

    /**
     * @return
     */
    @Override
    public boolean hasParent() {
        return getParent() == null;
    }

    /**
     * @return
     */
    @Override
    public boolean hasChildren() {
        return leftChild != null || rightChild != null;
    }

    /**
     * @return
     */
    @Override
    public List<SearchTreeNode<K, V>> getChildren() {
        List<SearchTreeNode<K, V>> list = new ArrayList<>(2);
        if (leftChild != null) {
            list.add(leftChild);
        }
        if (rightChild != null) {
            list.add(rightChild);
        }
        return list;
    }

    public BinarySearchTreeNode<K, V> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(BinarySearchTreeNode<K, V> leftChild) {
        this.leftChild = leftChild;
    }

    public BinarySearchTreeNode<K, V> getRightChild() {
        return rightChild;
    }

    public void setRightChild(BinarySearchTreeNode<K, V> rightChild) {
        this.rightChild = rightChild;
    }

    public void setParent(BinarySearchTreeNode<K, V> parent) {
        this.parent = parent;
    }

    @Override
    public String toString() {
        return "BinarySearchTreeNode [entry=" + entry + ", parent="
                + (parent == null ? "null" : parent.getEntry()) + ", leftChild="
                + (leftChild == null ? "null" : leftChild.getEntry()) + ", rightChild="
                + (rightChild == null ? "null" : rightChild.getEntry()) + "]";
    }

}
