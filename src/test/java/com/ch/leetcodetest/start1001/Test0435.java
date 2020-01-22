package com.ch.leetcodetest.start1001;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @User: chang
 * 给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
 *
 * 注意:
 *
 * 可以认为区间的终点总是大于它的起点。
 * 区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。
 * 示例 1:
 *
 * 输入: [ [1,2], [2,3], [3,4], [1,3] ]
 *
 * 输出: 1
 *
 * 解释: 移除 [1,3] 后，剩下的区间没有重叠。
 * 示例 2:
 *
 * 输入: [ [1,2], [1,2], [1,2] ]
 *
 * 输出: 2
 *
 * 解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。
 * 示例 3:
 *
 * 输入: [ [1,2], [2,3] ]
 *
 * 输出: 0
 *
 * 解释: 你不需要移除任何区间，因为它们已经是无重叠的了。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/non-overlapping-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test0435 {

    class Interval{
        int start;
        int end;

        public Interval(){

        }
        public Interval(int start,int end){
            this.start = start;
            this.end = end;
        }
    }

    class myComparator implements Comparator<Interval> {
        @Override
        public int compare(Interval a, Interval b) {
            return a.start - b.start;
        }
    }
    public int eraseOverlapIntervals(Interval[] intervals) {
        Arrays.sort(intervals, new myComparator());
        return erase_Overlap_Intervals(-1, 0, intervals);
    }
    public int erase_Overlap_Intervals(int prev, int curr, Interval[] intervals) {
        if (curr == intervals.length) {
            return 0;
        }
        int taken = Integer.MAX_VALUE, nottaken;
        if (prev == -1 || intervals[prev].end <= intervals[curr].start) {
            taken = erase_Overlap_Intervals(curr, curr + 1, intervals);
        }
        nottaken = erase_Overlap_Intervals(prev, curr + 1, intervals) + 1;
        return Math.min(taken, nottaken);
    }

    @Test
    public void test(){
        Interval[] intervals = new Interval[4];
        intervals[0] = new Interval(1,2);
        intervals[1] = new Interval(2,3);
        intervals[2] = new Interval(3,4);
        intervals[3] = new Interval(1,3);
        int least = eraseOverlapIntervals(intervals);
        System.out.println(least);
    }
}
