package com.ch.leetcodetest.start1001;

import org.junit.Test;

/**
 * @User: chang
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * 示例 1:
 *
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 *
 * 输入: "race a car"
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-palindrome
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test1125 {

    public boolean isPalindrome1(String s) {
        if (s.trim().equals("")){
            return true;
        }
        s = s.toUpperCase();
        int i = 0;
        int j = s.length()-1;
        while (i<j){
            //校验i,j是否越界
            if (j<0||i>s.length()-1){
                return false;
            }

            //判断i，j位置是不是字母或数字
            while (i<s.length()&&!((s.charAt(i)>='0'&&s.charAt(i)<='9')||(s.charAt(i)>='A'&&s.charAt(i)<='Z'))){
                i++;
            }
            while (j>=0&&!((s.charAt(j)>='0'&&s.charAt(j)<='9')||(s.charAt(j)>='A'&&s.charAt(j)<='Z'))){
                j--;
            }
            //刚开始做的时候没有考虑没有值的情况，一致索引出界  ",."
            if (i>=s.length()&&j<0){
                break;
            }else if (s.charAt(i)==s.charAt(j)){
                i++;
                j--;
            }else {
                return false;
            }
        }
        return true;
    }

    @Test
    public void test(){
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome("race a car"));
        System.out.println(isPalindrome(".,"));

    }

    /**
     * 网上优化的写法
     * @param s
     * @return
     */
    public boolean isPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i < j; ) {
            char ic = s.charAt(i);
            char jc = s.charAt(j);
            // A 65  a  97  ' '32
            if (ic >= 'A' && ic <= 'Z') {
                ic += 32;
            }
            if (jc >= 'A' && jc <= 'Z') {
                jc += 32;
            }
            if (!((ic >= 'a' && ic <= 'z') || (ic >= '0' && ic <= '9'))) {
                i++;
                continue;
            }
            if (!((jc >= 'a' && jc <= 'z') || (jc >= '0' && jc <= '9'))) {
                j--;
                continue;
            }
            if (ic != jc) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
