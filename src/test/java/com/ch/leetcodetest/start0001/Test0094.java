package com.ch.leetcodetest.start0001;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @User: chang
 * 给定一个二叉树，返回它的中序 遍历。
 *
 * 示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,3,2]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test0094 {
    // 递归
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        addInorder(root,list);
        return list;
    }
    public void addInorder(TreeNode root,List<Integer> list){
        if (root==null){
            return;
        }
        addInorder(root.left,list);
        list.add(root.val);
        addInorder(root.right,list);
    }

    // 基于栈的遍历
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur!=null || !stack.isEmpty()){
            while (cur!=null){
                stack.push(cur);
                cur=cur.left;
            }
            cur=stack.pop();
            list.add(cur.val);
            cur=cur.right;
        }
        return list;
    }

    @Test
    public void test(){
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(3);
        root.right=new TreeNode(4);
        root.left.left=new TreeNode(5);
        System.out.println("=============递归===============");
        System.out.println(inorderTraversal(root));
        System.out.println("=============迭代===============");
        System.out.println(inorderTraversal1(root));
    }
}
