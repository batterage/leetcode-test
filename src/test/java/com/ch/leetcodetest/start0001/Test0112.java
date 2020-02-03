package com.ch.leetcodetest.start0001;

import lombok.Data;
import org.junit.Test;

/**
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 */
public class Test0112 {
    @Test
    public void test() {

    }

    public static boolean hasPathSum(TreeNode root, int sum) {
        if (root==null){
            return false;
        }
        sum-=root.val;
        if (root.left==null&&root.right==null){
            return sum==0;
        }
        return hasPathSum(root.left,sum)||hasPathSum(root.right,sum);
    }
}
@Data
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
/*
TreeNode root = new TreeNode(2);
        root.left = new TreeNode(3);
        root.right=new TreeNode(4);
        root.left.left=new TreeNode(5);
 */