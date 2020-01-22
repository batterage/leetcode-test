package com.ch.leetcodetest.start0001;

import org.junit.Test;

/**
 * @User: chang
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 你可以假设数组中无重复元素。
 *
 * 示例 1:
 *
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * 示例 2:
 *
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * 示例 3:
 *
 * 输入: [1,3,5,6], 7
 * 输出: 4
 * 示例 4:
 *
 * 输入: [1,3,5,6], 0
 * 输出: 0
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-insert-position
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test0035 {

    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        int mid;
        //二分法找到值
        while (left<=right){
            if (target>nums[right]){
                return right+1;
            }else if (target<nums[left]){
                return left;
            }
            mid = (left+right)/2;
            if (target<nums[mid]){
                right=mid-1;
            }else if (target>nums[mid]){
                left=mid+1;
            }else {
                return mid;
            }
        }
        return -1;
    }

    @Test
    public void test(){
        int[] nums = {1,3,5,6};
        System.out.println(searchInsert(nums,0));
    }

}
