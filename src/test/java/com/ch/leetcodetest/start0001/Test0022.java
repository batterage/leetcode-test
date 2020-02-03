package com.ch.leetcodetest.start0001;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @User: chang
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 *
 * 例如，给出 n = 3，生成结果为：
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test0022 {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        backtrack(list,"",0,0,n);
        return list;
    }
    public void backtrack(List<String> ans,String cur,int open,int close,int max){
        if (cur.length()==max*2){
            ans.add(cur);
            return;
        }
        if (open<max){
            backtrack(ans,cur+"(",open+1,close,max);
        }
        if (close<open){
            backtrack(ans,cur+")",open,close+1,max);
        }
    }

    /**
     * 官网的暴力解法
     * 时间复杂度：O(2^{2n}n),空间复杂度O(2^{2n}n)
     * @param n
     * @return
     */
    public List<String> generateParenthesis1(int n) {
        List<String> combinations = new ArrayList();
        generateAll(new char[2 * n], 0, combinations);
        return combinations;
    }

    public void generateAll(char[] current, int pos, List<String> result) {
        if (pos == current.length) {
            if (valid(current))
                result.add(new String(current));
        } else {
            current[pos] = '(';
            generateAll(current, pos+1, result);
            current[pos] = ')';
            generateAll(current, pos+1, result);
        }
    }

    public boolean valid(char[] current) {
        int balance = 0;
        for (char c: current) {
            if (c == '(') balance++;
            else balance--;
            if (balance < 0) return false;
        }
        return (balance == 0);
    }

    @Test
    public void test(){
        generateParenthesis(3).forEach(System.out::println);
    }

}
