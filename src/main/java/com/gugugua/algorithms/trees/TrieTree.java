package com.gugugua.algorithms.trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

/**
 * @author cairne huangyihua@diandian.com
 * @date 2012-6-23
 *       　TrieTree有3个基本特性：
 *       　　1）根节点不包含字符，除根节点外每一个节点都只包含一个字符。
 *       　　2）从根节点到某一节点，路径上经过的字符连接起来，为该节点对应的字符串。
 *       　　3）每个节点的所有子节点包含的字符都不相同。
 */
public class TrieTree {

    private final TrieTreeNode root;

    public TrieTree() {
        root = new TrieTreeNode(null);
    }

    public void addWord(String word) {
        insert(root, word, 0);
    }

    /**
     * can be only prefix
     * 
     * @param word
     * @return
     */
    public List<String> search(String word) {
        return _search(root, word, -1, "");
    }

    protected List<String> _search(TrieTreeNode node, String word, int charIndex, String preString) {
        if (node.getChildren().size() == 0) {
            if (word.length() <= charIndex + 1) {
                return Collections.singletonList(preString + node.getValueIgnoreNull());
            } else {
                return Collections.emptyList();
            }
        }
        List<String> list = new ArrayList<>();
        if (word.length() > charIndex + 1) {
            for (TrieTreeNode child : node.getChildren()) {
                if (child.getValue().equals(word.charAt(charIndex + 1))) {
                    list.addAll(_search(child, word, charIndex + 1,
                            preString + node.getValueIgnoreNull()));
                }
            }
        } else {
            for (TrieTreeNode child : node.getChildren()) {
                list.addAll(_search(child, word, charIndex + 1,
                        preString + node.getValueIgnoreNull()));
            }
        }
        return list;
    }

    protected TrieTreeNode insert(TrieTreeNode node, String word, int charIndex) {
        if (node == null || word == null || word.length() <= charIndex) {
            return null;
        }
        ListIterator<TrieTreeNode> listIterator = node.getChildren().listIterator();
        ListIterator<TrieTreeNode> lastListIterator = listIterator;
        while (listIterator.hasNext()) {
            TrieTreeNode next = listIterator.next();
            int compareTo = next.getValue().compareTo(word.charAt(charIndex));
            if (compareTo == 0) {
                return insert(next, word, charIndex + 1);
            } else if (compareTo > 0) {
                TrieTreeNode newNode = new TrieTreeNode(word.charAt(charIndex));
                lastListIterator.add(newNode);
                newNode.setParent(node);
                insert(newNode, word, charIndex + 1);
                return newNode;
            } else {
                lastListIterator = listIterator;
            }
        }
        TrieTreeNode newNode = new TrieTreeNode(word.charAt(charIndex));
        listIterator.add(newNode);
        newNode.setParent(node);
        insert(newNode, word, charIndex + 1);
        return newNode;

    }

    TrieTreeNode getRoot() {
        return root;
    }

}
