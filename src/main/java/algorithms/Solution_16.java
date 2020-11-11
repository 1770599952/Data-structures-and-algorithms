package algorithms;


/**实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。

 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。

 必须原地修改，只允许使用额外常数空间。

 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 1,2,3 → 1,3,2
 3,2,1 → 1,2,3
 1,1,5 → 1,5,1

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/next-permutation
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。**/
public class Solution_16 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        nextPermutation(nums);
        System.out.println(nums);
    }

    public static void nextPermutation(int[] nums) {

        Integer index = null;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                index = i;
                break;
            }
        }

        if (index == null) {
            sort(nums, 0);
        } else {
            for (int i = nums.length - 1; i > index; i--) {
                if (nums[i] > nums[index]) {
                    swap(nums, i, index);
                    break;
                }
            }
            sort(nums, index + 1);
        }
    }

    private static void sort(int[] nums, Integer index) {
        for (int i = index; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    swap(nums, i, j);
                }
            }
        }
    }

    private static void swap(int[] nums, Integer i, Integer index) {
        Integer temp = nums[i];
        nums[i] = nums[index];
        nums[index] = temp;
    }
}
