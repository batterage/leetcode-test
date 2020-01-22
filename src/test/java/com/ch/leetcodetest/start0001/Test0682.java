package com.ch.leetcodetest.start0001;

import org.junit.Test;

import java.util.Stack;

/**
 * @User: chang
 * 你现在是棒球比赛记录员。
 * 给定一个字符串列表，每个字符串可以是以下四种类型之一：
 * 1.整数（一轮的得分）：直接表示您在本轮中获得的积分数。
 * 2. "+"（一轮的得分）：表示本轮获得的得分是前两轮有效 回合得分的总和。
 * 3. "D"（一轮的得分）：表示本轮获得的得分是前一轮有效 回合得分的两倍。
 * 4. "C"（一个操作，这不是一个回合的分数）：表示您获得的最后一个有效 回合的分数是无效的，应该被移除。
 *
 * 每一轮的操作都是永久性的，可能会对前一轮和后一轮产生影响。
 * 你需要返回你在所有回合中得分的总和。
 *
 * 示例 1:
 *
 * 输入: ["5","2","C","D","+"]
 * 输出: 30
 * 解释:
 * 第1轮：你可以得到5分。总和是：5。
 * 第2轮：你可以得到2分。总和是：7。
 * 操作1：第2轮的数据无效。总和是：5。
 * 第3轮：你可以得到10分（第2轮的数据已被删除）。总数是：15。
 * 第4轮：你可以得到5 + 10 = 15分。总数是：30。
 * 示例 2:
 *
 * 输入: ["5","-2","4","C","D","9","+","+"]
 * 输出: 27
 * 解释:
 * 第1轮：你可以得到5分。总和是：5。
 * 第2轮：你可以得到-2分。总数是：3。
 * 第3轮：你可以得到4分。总和是：7。
 * 操作1：第3轮的数据无效。总数是：3。
 * 第4轮：你可以得到-4分（第三轮的数据已被删除）。总和是：-1。
 * 第5轮：你可以得到9分。总数是：8。
 * 第6轮：你可以得到-4 + 9 = 5分。总数是13。
 * 第7轮：你可以得到9 + 5 = 14分。总数是27。
 * 注意：
 *
 * 输入列表的大小将介于1和1000之间。
 * 列表中的每个整数都将介于-30000和30000之间。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/baseball-game
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test0682 {

    /**
     * 利用栈保存需要求和的得分，效率没有直接数组高
     * @param ops
     * @return
     */
    public int calPoints1(String[] ops) {
        int sum =0;
        Stack<Integer> stack = new Stack<>();
        for (int i=0;i<ops.length;i++){
            if (ops[i].equals("+")){
                //累加前两轮的分数
                int pre = stack.pop();
                int pre2 = stack.peek();
                int cur = pre+pre2;
                stack.push(pre);
                stack.push(cur);
            }else if(ops[i].equals("D")){
                stack.push(stack.peek()*2);
            }else if (ops[i].equals("C")){
                if (stack.isEmpty()){
                    continue;
                }
                stack.pop();
            }else {
                stack.push(Integer.valueOf(ops[i]));
            }
        }
        //求最后结果
        while (stack.size()>0){
            sum+=stack.pop();
        }
        return sum;
    }

    @Test
    public void test(){
        //分数入栈，字母根据情况入栈或出栈，遍历完字符数组，求栈里面数字的和为总分
        String[] ops = {"5","-2","4","C","D","9","+","+"};
        System.out.println(calPoints(ops));
    }

    /**
     * 直接数组计算
     * @param ops
     * @return
     */
    public int calPoints(String[] ops) {
        int[] sums = new int[ops.length];
        //前一个有效分数
        int index =0;
        int sum =0;
        for (int i=0;i<ops.length;i++){
            if (ops[i].equals("+")){
                //累加前两轮的分数
                sums[index]= sums[index-1]+sums[index-2];
                sum+=sums[index];
                index++;
            }else if(ops[i].equals("D")){
                sums[index]= sums[index-1]*2;
                sum+=sums[index];
                index++;
            }else if (ops[i].equals("C")){
                sum-=sums[index-1];
                index--;
            }else {
                sums[index]=Integer.valueOf(ops[i]);
                sum+=sums[index];
                index++;
            }
        }
        return sum;
    }
}
