package com.ch.leetcodetest.start0001;

import org.junit.Test;

/**
 * @User: chang
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 3 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test0104 {
    public int maxDepth(TreeNode root) {
        return getlen(root,0);
    }

    public int getlen(TreeNode root,int len){
        if (root==null){
            return len;
        }
        int left = getlen(root.left,len+1);
        int right = getlen(root.right,len+1);
        return Math.max(left,right);
    }

    @Test
    public void test(){
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(3);
        root.right=new TreeNode(4);
        root.left.left=new TreeNode(5);
        System.out.println(maxDepth(root));
    }
}
