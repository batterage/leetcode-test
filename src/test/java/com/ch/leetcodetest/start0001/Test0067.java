package com.ch.leetcodetest.start0001;

import org.junit.Test;

/**
 * @User: chang
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。
 *
 * 输入为非空字符串且只包含数字 1 和 0。
 *
 * 示例 1:
 *
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 示例 2:
 *
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-binary
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test0067 {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length()-1;
        int j = b.length()-1;
        int c=0;
        while (i>=0||j>=0){
            //没有了就补0
            int n1 = i>=0 ? a.charAt(i) - '0' : 0;
            int n2 = j>=0 ? b.charAt(j) - '0' : 0;
            //记得加上进位
            c = n1+n2+c;
            sb.append(c%2);
            c /=2;
            i--;
            j--;
        }
        //查看最后有没有进位
        if (c==1){
            sb.append(1);
        }
        return sb.reverse().toString();
    }

    @Test
    public void test(){
        String a = "1010", b = "1011";
        System.out.println(addBinary(a,b));
    }
}
