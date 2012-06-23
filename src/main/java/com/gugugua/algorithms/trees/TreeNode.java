package com.gugugua.algorithms.trees;

import java.util.List;

/**
 * @author cairne huangyihua@diandian.com
 * @date 2012-6-23
 */
interface TreeNode<T> {

    T getValue();

    List<? extends TreeNode<T>> getChildren();

    TreeNode<T> getParent();

}
