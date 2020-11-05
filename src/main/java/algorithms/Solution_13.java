package algorithms;

import java.util.List;

/**
 * 给出一个无重叠的 ，按照区间起始端点排序的区间列表。
 * <p>
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出：[[1,5],[6,9]]
 * 示例 2：
 * <p>
 * 输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * 输出：[[1,2],[3,10],[12,16]]
 * 解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
 *  
 * <p>
 * 注意：输入类型已在 2019 年 4 月 15 日更改。请重置为默认代码定义以获取新的方法签名。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/insert-interval
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class Solution_13 {
    public static void main(String[] args) {
        int[][] intervals = {{1, 5}};
        int[] newInterval = {0, 6};
        System.out.println(insert(intervals, newInterval));
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {

        int startIndex = newInterval[0];
        int endIndex = newInterval[1];
        if (intervals.length == 0) {
            intervals = new int[1][2];
            intervals[0] = new int[]{startIndex, endIndex};
        }

        Integer startRegion = null;
        Integer endRegion = null;
        for (int i = 0; i < intervals.length; i++) {
            // 1.newInterval 起始位置是否在intervals区间内。
            if (startIndex >= intervals[i][0] && startIndex <= intervals[i][1]) {
                int curRegionStartIndex = intervals[i][0];
                int curRegionEndIndex = intervals[i][1];
                startRegion = i;
            }
            // 2.newInterval 结束位置是否在intervals区间内。
            if (endIndex >= intervals[i][0] && endIndex <= intervals[i][1]) {
                int curRegionStartIndex = intervals[i][0];
                int curRegionEndIndex = intervals[i][1];
                endRegion = i;
            }
        }

        Integer startBefore = null;
        Integer endBefore = null;

        // newInterval 起始位置在intervals区间内
        if (startRegion != null) {
            //newInterval 结束位置在intervals区间内
            if (endRegion != null) {
                if (startRegion != endRegion) {
                    int[] Interval = {intervals[startRegion][0], intervals[endRegion][1]};
                    for (int i = startRegion; i <= endRegion; i++) {
                        intervals[i] = null;
                    }
                    intervals[startRegion] = Interval;
                }
            } else {
                for (int i = 0; i < intervals.length; i++) {
                    if (endIndex < intervals[i][0]) {
                        endBefore = i;
                        break;
                    }
                }

                if (endBefore == null) {
                    endBefore = intervals.length;
                }

                int[] Interval = {intervals[startRegion][0], endIndex};

                for (int i = startRegion; i < endBefore; i++) {
                    intervals[i] = null;
                }

                intervals[startRegion] = Interval;
            }
        } else {
            //newInterval 结束位置在intervals区间内
            if (endRegion != null) {
                for (int i = 0; i < intervals.length; i++) {
                    if (startIndex < intervals[i][0]) {
                        startBefore = i;
                        break;
                    }
                }
                int[] Interval = {startIndex, intervals[endRegion][1]};

                for (int i = startBefore; i <= endRegion; i++) {
                    intervals[i] = null;
                }

                intervals[startBefore] = Interval;
            } else {
                int[] Interval = {startIndex, endIndex};
                for (int i = 0; i < intervals.length; i++) {
                    if (startIndex < intervals[i][0]) {
                        startBefore = i;
                        break;
                    }
                }

                for (int i = 0; i < intervals.length; i++) {
                    if (endIndex < intervals[i][0]) {
                        endBefore = i;
                        break;
                    }
                }

                if (startBefore == endBefore) {
                    int[][] result = new int[intervals.length + 1][2];
                    if (startBefore == null) {
                        for (int i = 0; i < intervals.length; i++) {
                            result[i] = intervals[i];
                        }
                        result[intervals.length] = Interval;
                    } else {
                        int j = 0;
                        for (int i = 0; i < intervals.length; i++) {
                            if (i == startBefore) {
                                result[j] = Interval;
                                result[++j] = intervals[i];
                            } else {
                                result[j] = intervals[i];
                            }
                            j++;
                        }
                    }

                    intervals = result;
                } else {
                    if (endBefore == null) {
                        endBefore = intervals.length;
                    }
                    for (int i = startBefore; i < endBefore; i++) {
                        intervals[i] = null;
                    }
                    intervals[startBefore] = Interval;
                }
            }
        }

        int size = 0;

        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i] != null) {
                size++;
            }
        }

        int[][] result = new int[size][2];
        int j = 0;
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i] != null) {
                result[j++] = intervals[i];
            }
        }
        System.out.println(intervals);
        // 2.
        return result;
    }
}
