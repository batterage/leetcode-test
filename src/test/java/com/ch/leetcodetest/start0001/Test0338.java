package com.ch.leetcodetest.start0001;

import org.junit.Test;

/**
 * @User: chang
 * 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
 *
 * 示例 1:
 *
 * 输入: 2
 * 输出: [0,1,1]
 * 示例 2:
 *
 * 输入: 5
 * 输出: [0,1,1,2,1,2]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/counting-bits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test0338 {
    /*
    时间复杂度是O(n*sizeof(integer))
     */
    public int[] countBits1(int num) {
        int[] result = new int[num+1];
        result[0]=0;
        for (int i = 1; i <= num; i++) {
            int n=0;
            int tmp =i;
            while (tmp>0){
                if ((tmp&1)==1){
                    n++;
                }
                tmp/=2;
            }
            result[i]=n;
        }
        return result;
    }

    /**
     * 动态规划 + 最高有效位
     * 时间复杂度 O(n)
     * @param num
     * @return
     */
    public int[] countBits2(int num) {
        int[] ans = new int[num + 1];
        int i = 0, b = 1;
        // [0, b) is calculated
        while (b <= num) {
            // generate [b, 2b) or [b, num) from [0, b)
            while(i < b && i + b <= num){
                ans[i + b] = ans[i] + 1;
                ++i;
            }
            i = 0;   // reset i
            b <<= 1; // b = 2b
        }
        return ans;
    }

    /**
     * 动态规划 + 最后设置位【通过】
     * @param num
     * @return
     */
    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        for(int i = 1;i <= num;i ++){
            //最后设置位是从右到左第一个为1的位。使用 x &= x - 1 将该位设置为0
            res[i] = res[i & (i - 1)] + 1;
        }
        return res;
    }
    @Test
    public void test(){
        int[] result = countBits(5);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
