package com.ch.leetcodetest.start0001;

import org.junit.Test;

/**
 * @User: chang
 * 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
 *
 * 给出两个整数 x 和 y，计算它们之间的汉明距离。
 *
 * 注意：
 * 0 ≤ x, y < 231.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/hamming-distance
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test0461 {
    public int hammingDistance(int x, int y) {
        int n = x^y;
        int result = 0;
        while (n>0){
            if ((n%2)==1){
                result++;
            }
            n/=2;
        }
        return result;
    }
    @Test
    public void test(){
        System.out.println(hammingDistance(1, 4));
    }
}
