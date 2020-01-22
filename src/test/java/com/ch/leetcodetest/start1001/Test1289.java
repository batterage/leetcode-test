package com.ch.leetcodetest.start1001;

import org.junit.Test;

/**
 * @User: chang
 * 给你一个整数方阵 arr ，定义「非零偏移下降路径」为：从 arr 数组中的每一行选择一个数字，且按顺序选出来的数字中，相邻数字不在原数组的同一列。
 * <p>
 * 请你返回非零偏移下降路径数字和的最小值。
 * 示例 1：
 * <p>
 * 输入：arr = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：13
 * 解释：
 * 所有非零偏移下降路径包括：
 * [1,5,9], [1,5,7], [1,6,7], [1,6,8],
 * [2,4,8], [2,4,9], [2,6,7], [2,6,8],
 * [3,4,8], [3,4,9], [3,5,7], [3,5,9]
 * 下降路径中数字和最小的是 [1,5,7] ，所以答案是 13 。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= arr.length == arr[i].length <= 200
 * -99 <= arr[i][j] <= 99
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-falling-path-sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test1289 {
    private static int min = Integer.MAX_VALUE;

    /**
     * 只能计算n较小的数，时间复杂度 n^n次方
     *
     * @param arr
     * @return
     */
    public int minFallingPathSum(int[][] arr) {
        //保存路径
        int[] road = new int[arr.length];
        for (int i = 0; i < road.length; i++) {
            road[i] = -100;
        }
        //遍历第一个数组
        for (int i = 0; i < arr.length; i++) {
            next(arr, road, 1);
        }
        //返回最小结果
        return min;
    }

    private void next(int[][] arr, int[] road, int depth) {
        if (depth > arr.length) {
            return;
        }
        //已经到达最后一层了
        if (depth == arr.length) {
            for (int i = 0; i < road.length; i++) {
                //找到最后一层
                if (isPossible(road, i, depth)) {
                    min = Math.min(min, getSum(arr, road));
                }
            }
            return;
        }
        //不是最后一层，继续找
        for (int i = 0; i < road.length; i++) {
            if (isPossible(road, i, depth)) {
                next(arr, road, depth + 1);
            }
        }
    }

    /**
     * 求下一个是否是可能的点
     */
    public boolean isPossible(int[] road, int index, int depth) {
        if (depth == 1) {
            road[0] = index;
            return true;
        }
        if (index == road[depth - 2]) {
            return false;
        }
        //当前点符合条件，继续
        road[depth - 1] = index;
        return true;
    }

    /**
     * 求当前路径的下降路径和
     */
    private int getSum(int[][] arr, int[] road) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i][road[i]] + " ");
            sum += arr[i][road[i]];
        }

        System.out.println();
        return sum;
    }


    @Test
    public void test() {
        int[][] arr = {{1, 1, 1}, {1, 1, 1}, {1, 1, 1}};
        //答案-879
        int[][] arr1 = {
                {-2, -18, 31, -10, -71, 82, 47, 56, -14, 42},
                {-95, 3, 65, -7, 64, 75, -51, 97, -66, -28},
                {36, 3, -62, 38, 15, 51, -58, -90, -23, -63},
                {58, -26, -42, -66, 21, 99, -94, -95, -90, 89},
                {83, -66, -42, -45, 43, 85, 51, -86, 65, -39},
                {56, 9, 9, 95, -56, -77, -2, 20, 78, 17},
                {78, -13, -55, 55, -7, 43, -98, -89, 38, 90},
                {32, 44, -47, 81, -1, -55, -5, 16, -81, 17},
                {-87, 82, 2, 86, -88, -58, -91, -79, 44, -9},
                {-96, -14, -52, -8, 12, 38, 84, 77, -51, 52}};
        System.out.println(minFallingPathSum1(arr1));
    }
    private int[] getPrevRowMinArr(int[][] dp, int i) {
        int n = dp.length;
        int[] minArr = new int[n]; // 除自己之外的最小值
        // 先求最小的两个数
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int j = 0; j < n; j++) {
            if (dp[i][j] < min) {
                min = dp[i][j];
                minIndex = j;
            }
        }

        int secondMin = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            if (j != minIndex && dp[i][j] < secondMin) {
                secondMin = dp[i][j];
            }
        }

        for (int j = 0; j < n; j++) {
            if (j == minIndex) {
                minArr[j] = secondMin;
            } else {
                minArr[j] = min;
            }
        }

        return minArr;
    }

    public int minFallingPathSum1(int[][] arr) {
        int n = arr.length;
        int[][] dp = new int[n][n];

        for (int j = 0; j < n; j++) {
            dp[0][j] = arr[0][j];
        }

        // 记录上一行的每个位置除自己外的最小值
        int[] prevRowMinArr = getPrevRowMinArr(dp, 0);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int prevRowMin = prevRowMinArr[j];
                dp[i][j] = prevRowMin + arr[i][j];
            }
            prevRowMinArr = getPrevRowMinArr(dp, i);
        }

        int ans = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            ans = Math.min(ans, dp[n-1][j]);
        }

        return ans;
    }
}
