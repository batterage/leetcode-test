package com.ch.leetcodetest.start0001;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @User: chang
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test0046 {
    /*
    我自己的递推回溯，50%，
     */
    public List<List<Integer>> permute1(int[] nums) {
        int len = nums.length;
        List<List<Integer>> list = new ArrayList<>();
        int[] tmp = new int[len];
        for (int i = 0; i < len; i++) {
            tmp[0]=nums[i];
            addIndex(list,nums,tmp,1);
        }
        return list;
    }
    //添加第len个元素(0开始)
    public void addIndex(List<List<Integer>> list,int[]nums,int[] tmp,int len){
        if (len==tmp.length){
            addList(list,tmp);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (isallowed(tmp,nums[i],len)){
                tmp[len]=nums[i];
                addIndex(list,nums,tmp,len+1);
            }
        }
    }
    public boolean isallowed(int[] tmps,int value,int len){
        for (int i = 0; i < len; i++) {
            if (tmps[i]==value){
                return false;
            }
        }
        return true;
    }
    public void addList(List<List<Integer>> list,int[] tmps){
        List<Integer> oneList = new ArrayList<>();
        for (int i = 0; i < tmps.length; i++) {
            oneList.add(tmps[i]);
        }
        list.add(oneList);
    }

    /*
    题解的递归
     */
    public void backtrack(int n,
                          ArrayList<Integer> nums,
                          List<List<Integer>> output,
                          int first) {
        // if all integers are used up
        if (first == n)
            output.add(new ArrayList<Integer>(nums));
        for (int i = first; i < n; i++) {
            // place i-th integer first
            // in the current permutation
            Collections.swap(nums, first, i);
            // use next integers to complete the permutations
            backtrack(n, nums, output, first + 1);
            // backtrack
            Collections.swap(nums, first, i);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        // init output list
        List<List<Integer>> output = new LinkedList();

        // convert nums into list since the output is a list of lists
        ArrayList<Integer> nums_lst = new ArrayList<Integer>();
        for (int num : nums)
            nums_lst.add(num);

        int n = nums.length;
        backtrack(n, nums_lst, output, 0);
        return output;
    }
    @Test
    public void test(){
        int[] nums = {1,2};
        permute(nums).forEach(System.out::println);
    }
}
