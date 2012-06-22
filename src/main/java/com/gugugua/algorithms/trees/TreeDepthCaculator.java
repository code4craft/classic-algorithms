package com.gugugua.algorithms.trees;

/**
 * @author cairne huangyihua@diandian.com
 * @date 2012-6-22
 */
public class TreeDepthCaculator {

    private int maxDepth = 0;

    public int calcDepth(SearchTree<?, ?> tree) {
        if (tree.getRoot() == null) {
            return 0;
        }
        calcDepth(tree.getRoot(), 1);
        return maxDepth;
    }

    private void calcDepth(SearchTreeNode<?, ?> node, int depth) {
        if (!node.hasChildren()) {
            if (depth > maxDepth) {
                maxDepth = depth;
            }
        } else {
            for (SearchTreeNode<?, ?> child : node.getChildren()) {
                calcDepth(child, depth + 1);
            }
        }
    }
}
