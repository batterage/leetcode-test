package com.ch.leetcodetest.start0001;

import org.junit.Test;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @User: chang
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 示例 2:
 *
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/plus-one
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test0066 {
    public int[] plusOne(int[] digits) {
        int c=1;
        for (int i=digits.length-1;i>=0;i--){
            c += digits[i];
            digits[i]=c%10;
            c/=10;
        }
        if (c==1){
            //需要进位
            int[] newArr = new int[digits.length+1];
            newArr[0]=1;
            for (int i=0;i<digits.length;i++){
                newArr[i+1]=digits[i];
            }
            return newArr;
        }
        return digits;
    }

    @Test
    public void test(){
        int[] nums = {1,2,3};
        nums=plusOne(nums);
        IntStream stream = Arrays.stream(nums);
        stream.forEach(System.out::println);

    }
}
