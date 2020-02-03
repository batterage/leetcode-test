package com.ch.leetcodetest.start0001;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

/**
 * @User: chang
 * 翻转一棵二叉树。
 *
 * 示例：
 *
 * 输入：
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 *
 * 输出：
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 */
public class Test0226 {
    public TreeNode invertTree(TreeNode root) {
        if (root==null){
            return null;
        }
        TreeNode temp = root.left;
        root.left=root.right;
        root.right=temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    @Test
    public void test(){
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(3);
        root.right=new TreeNode(4);
        root.left.left=new TreeNode(5);
        invertTree(root);
        System.out.println(JSON.toJSONString(root));
    }
}
