package algorithms;

/**
 * 给定一个整数数组 A，如果它是有效的山脉数组就返回 true，否则返回 false。
 * <p>
 * 让我们回顾一下，如果 A 满足下述条件，那么它是一个山脉数组：
 * <p>
 * A.length >= 3
 * 在 0 < i < A.length - 1 条件下，存在 i 使得：
 * A[0] < A[1] < ... A[i-1] < A[i]
 * A[i] > A[i+1] > ... > A[A.length - 1]
 *  
 * <p>
 * <p>
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：[2,1]
 * 输出：false
 * 示例 2：
 * <p>
 * 输入：[3,5,5]
 * 输出：false
 * 示例 3：
 * <p>
 * 输入：[0,3,2,1]
 * 输出：true
 *  
 * <p>
 * 提示：
 * <p>
 * 0 <= A.length <= 10000
 * 0 <= A[i] <= 10000 
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-mountain-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 细心审题。
 **/
public class Solution_12 {

    public static void main(String[] args) {
        int[] A = {0, 1, 2, 4, 2, 1};
        System.out.println(validMountainArray(A));
    }

    public static boolean validMountainArray(int[] A) {

        boolean result = false;
        for (int index = 1; index < A.length - 1; index++) {
            result = true;

            for (int left = 0; left < index; left++) {
                if (A[left] < A[left + 1]) {
                    continue;
                } else {
                    result = false;
                    break;
                }
            }


            for (int right = index; right < A.length - 1; right++) {
                if (A[right] > A[right + 1]) {
                    continue;
                } else {
                    result = false;
                    break;
                }
            }


            if (result == true) {
                return result;
            }

        }
        return result;
    }
}
