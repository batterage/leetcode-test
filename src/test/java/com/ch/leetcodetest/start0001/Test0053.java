package com.ch.leetcodetest.start0001;

import org.junit.Test;

/**
 * @User: chang
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶:
 *
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test0053 {
    /**
     * 贪心求和
     * 看前面的和是多少，和本身取大的
     * @param nums
     * @return
     */
    public int maxSubArray1(int[] nums) {
        int maxSum = nums[0];
        int preSum = nums[0];
        for (int i=1;i<nums.length;i++){
            preSum = Math.max(preSum+nums[i],nums[i]);
            maxSum = Math.max(preSum,maxSum);
        }
        return maxSum;
    }

    @Test
    public void test(){
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }

    //分而治之
    public int maxSubArray(int[] nums) {
        int next = next(nums, 0, nums.length - 1);
        return next;
    }

    /**
     * 把一个数组分成两部分 left-mid  mid+1 - right  和 cross表示此数组最大的和是多少
     * @param nums
     * @param left
     * @param right
     * @return
     */
    private int next(int[] nums,int left,int right){
        if (left==right){
            return nums[left];
        }
        int mid = (left+right)/2;
        int leftCross = next(nums,left,mid);
        int rightCross = next(nums,mid+1,right);
        int cross = getCross(nums,left,right,mid);
        return Math.max(Math.max(leftCross,rightCross),cross);
    }
    //求index附件的最大和
    private int getCross(int[] nums,int left,int right,int index){
        int sum = 0;
        int leftMax = Integer.MIN_VALUE;
        int rightMax = Integer.MIN_VALUE;
        //先求左边的最大和
        for (int i=index;i>=left;i--){
            sum+=nums[i];
            leftMax = Math.max(sum,leftMax);
        }
        sum = 0;
        //求右边的最大和
        for (int i=index+1;i<=right;i++){
            sum+=nums[i];
            rightMax = Math.max(sum,rightMax);
        }
        return leftMax+rightMax;
    }
}
