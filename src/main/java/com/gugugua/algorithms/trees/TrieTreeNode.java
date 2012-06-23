package com.gugugua.algorithms.trees;

import java.util.LinkedList;
import java.util.List;

/**
 * @author cairne huangyihua@diandian.com
 * @date 2012-6-23
 */
public class TrieTreeNode implements TreeNode<Character> {

    private final Character value;

    private TrieTreeNode parent;

    private List<TrieTreeNode> children;

    /**
     * @param value
     */
    public TrieTreeNode(Character value) {
        super();
        this.value = value;
        children = new LinkedList<>();
    }

    /**
     * @return
     */
    @Override
    public Character getValue() {
        return value;
    }

    /**
     * @return
     */
    @Override
    public List<TrieTreeNode> getChildren() {
        return children;
    }

    /**
     * @return
     */
    @Override
    public TreeNode<Character> getParent() {
        return parent;
    }

    @Override
    public String toString() {
        return "TrieTreeNode [value=" + value + ", parent="
                + (parent == null ? null : parent.getValue()) + ", children=" + children + "]";
    }

    public void setParent(TrieTreeNode parent) {
        this.parent = parent;
    }

    public void setChildren(List<TrieTreeNode> children) {
        this.children = children;
    }

    public String getValueIgnoreNull() {
        if (value == null) {
            return "";
        }
        return value + "";
    }

}
