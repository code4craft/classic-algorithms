package com.gugugua.algorithms.trees;

import com.gugugua.algorithms.SearchEntry;

/**
 * @author cairne huangyihua@diandian.com
 * @date 2012-6-22
 */
class RedBlackTreeNode<K extends Comparable<K>, V> extends BinarySearchTreeNode<K, V> {

    //红黑树叶结点都是黑
    @SuppressWarnings({ "unchecked", "rawtypes" })
    private static final RedBlackTreeNode NIL_NODE = new RedBlackTreeNode(null, Color.Black);

    private Color color;

    static enum Color {
        Black, Red;
    }

    /**
     * @param entry
     */
    public RedBlackTreeNode(SearchEntry<K, V> entry) {
        super(entry);
    }

    /**
     * @param entry
     */
    public RedBlackTreeNode(SearchEntry<K, V> entry, Color color) {
        super(entry);
        this.color = color;
    }

    @Override
    public RedBlackTreeNode<K, V> getLeftChild() {
        return (RedBlackTreeNode<K, V>) leftChild;
    }

    /**
     * @return
     */
    @Override
    public RedBlackTreeNode<K, V> getRightChild() {
        return (RedBlackTreeNode<K, V>) rightChild;
    }

    /**
     * @return
     */
    @Override
    public RedBlackTreeNode<K, V> getParent() {
        return (RedBlackTreeNode<K, V>) parent;
    }

    Color getColor() {
        return color;
    }

    void setColor(Color color) {
        this.color = color;
    }

    public RedBlackTreeNode<K, V> getGrandParent() {
        if (!hasParent()) {
            return null;
        }
        return getParent().getParent();
    }

    @SuppressWarnings("unchecked")
    public RedBlackTreeNode<K, V> getUncle() {
        RedBlackTreeNode<K, V> grandParent = getGrandParent();
        if (grandParent == null) {
            System.out.println("not grand, " + getParent());
            return null;
        }
        if (this.getParent() == grandParent.getLeftChild()) {
            if (grandParent.getRightChild() != null) {
                return grandParent.getRightChild();
            } else {
                return NIL_NODE;
            }
        } else {
            if (grandParent.getLeftChild() != null) {
                return grandParent.getLeftChild();
            } else {
                return NIL_NODE;
            }
        }
    }

    public String toStringAll() {
        return "BinarySearchTreeNode [entry=" + getEntry() + ", color=" + color + ", parent="
                + (parent == null ? "null" : parent.getEntry()) + ", leftChild=" + leftChild
                + ", rightChild=" + rightChild + "]";
    }

}
