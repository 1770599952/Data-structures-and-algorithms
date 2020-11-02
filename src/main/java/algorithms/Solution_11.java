package algorithms;

import java.util.HashSet;

/**
 * 给定两个数组，编写一个函数来计算它们的交集。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 * 示例 2：
 * <p>
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[9,4]
 *  
 * <p>
 * 说明：
 * <p>
 * 输出结果中的每个元素一定是唯一的。
 * 我们可以不考虑输出结果的顺序。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class Solution_11 {
    public static void main(String[] args) {

    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> result = new HashSet<Integer>();

        HashSet<Integer> nums1Set = new HashSet<Integer>(nums1.length);
        HashSet<Integer> nums2Set = new HashSet<Integer>(nums2.length);

        for (int i = 0; i < nums1.length; i++) {
            nums1Set.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            nums2Set.add(nums2[i]);
        }

        for (int num : nums1Set) {
            if (nums2Set.contains(num)) {
                result.add(num);
            }
        }
        int[] intersection = new int[result.size()];
        int index = 0;
        for (int num : result) {
            intersection[index++] = num;
        }

        return intersection;
    }
}
