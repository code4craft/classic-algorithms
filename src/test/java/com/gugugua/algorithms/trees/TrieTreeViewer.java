package com.gugugua.algorithms.trees;

/**
 * @author cairne huangyihua@diandian.com
 * @date 2012-6-23
 */
public class TrieTreeViewer {

    public static void outputToConsole(TrieTree trieTree) {
        _outputToConsole(trieTree.getRoot(), "");
    }

    private static void _outputToConsole(TrieTreeNode node, String preString) {
        //叶结点
        if (node.getChildren().size() == 0) {
            System.out.println(" get word " + preString + node.getValue());
        }
        for (TrieTreeNode child : node.getChildren()) {
            String value = node.getValue() == null ? "" : "" + node.getValue();
            _outputToConsole(child, preString + value);
        }
    }
}
