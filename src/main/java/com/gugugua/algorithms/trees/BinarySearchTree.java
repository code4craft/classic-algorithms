package com.gugugua.algorithms.trees;

import com.gugugua.algorithms.SearchEntry;
import com.gugugua.algorithms.SearchStructure;

/**
 * @author cairne huangyihua@diandian.com
 * @date 2012-6-22
 */
public class BinarySearchTree<K extends Comparable<K>, V> implements SearchStructure<K, V>,
        SearchTree<K, V> {

    protected BinarySearchTreeNode<K, V> root;

    /**
     * @param entry
     */
    @Override
    public void add(SearchEntry<K, V> entry) {
        if (root == null) {
            root = new BinarySearchTreeNode<>(entry);
        } else {
            insert(root, entry);
        }
    }

    /**
     * 递归查找算法，P(n)=O(logn)
     * 
     * @param node
     * @param key
     * @return
     */
    protected void insert(BinarySearchTreeNode<K, V> node, SearchEntry<K, V> entry) {
        if (node == null || entry == null) {
            return;
        }
        int compareTo = entry.getKey().compareTo(node.getEntry().getKey());
        if (compareTo == 0) {
            return;
        } else if (compareTo < 0) {
            if (node.getLeftChild() != null) {
                insert(node.getLeftChild(), entry);
            } else {
                BinarySearchTreeNode<K, V> newNode = new BinarySearchTreeNode<>(entry);
                node.setLeftChild(newNode);
                newNode.setParent(node);
            }
        } else {
            if (node.getRightChild() != null) {
                insert(node.getRightChild(), entry);
            } else {
                BinarySearchTreeNode<K, V> newNode = new BinarySearchTreeNode<>(entry);
                node.setRightChild(newNode);
                newNode.setParent(node);
            }
        }
    }

    /**
     * @param key
     * @return
     */
    @Override
    public SearchEntry<K, V> get(K key) {
        BinarySearchTreeNode<K, V> searchNode = search(root, key);
        if (searchNode == null) {
            return null;
        } else {
            return searchNode.getEntry();
        }
    }

    /**
     * 递归查找算法，P(n)=O(logn)
     * 
     * @param node
     * @param key
     * @return
     */
    protected BinarySearchTreeNode<K, V> search(BinarySearchTreeNode<K, V> node, K key) {
        if (node == null || key == null) {
            return null;
        }
        int compareTo = key.compareTo(node.getEntry().getKey());
        if (compareTo == 0) {
            return node;
        } else if (compareTo < 0) {
            return search(node.getLeftChild(), key);
        } else {
            return search(node.getRightChild(), key);
        }
    }

    /**
     * @param key
     *        TODO:
     *        在二叉排序树删去一个结点，分三种情况讨论：
     *        　　若*p结点为叶子结点，即PL(左子树)和PR(右子树)均为空树。由于删去叶子结点不破坏整棵树的结构，
     *        则只需修改其双亲结点的指针即可
     *        。若*p结点只有左子树PL或右子树PR，此时只要令PL或PR直接成为其双亲结点*f的左子树（当
     *        *p是左子树）或右子树（当*p是右子树
     *        ）即可，作此修改也不破坏二叉排序树的特性。若*p结点的左子树和右子树均不空。在删去*p之后
     *        ，为保持其它元素之间的相对位置不变
     *        ，可按中序遍历保持有序进行调整，可以有两种做法：其一是令*p的左子树为*f的左子树，*s为
     *        *f左子树的最右下的结点，而*p的右子树为
     *        *s的右子树；其二是令*p的直接前驱（或直接后继）替代*p，然后再从二叉排序树中删去它的直接前驱（或直接后继）。
     *        不难理解但是过程繁琐，暂时不实现这个
     */
    @Override
    public void remove(K key) {
        // TODO Auto-generated method stub

    }

    /**
     * @return
     */
    @Override
    public SearchTreeNode<K, V> getRoot() {
        return root;
    }

}