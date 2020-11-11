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

    /**
     * 我们要找到下一个更大的序列，这个问题的本质是什么？
     *
     * 我们变动的位数，要尽可能靠右。因为越靠右，数字变化越小。
     *
     * 我们要从右向左遍历，找到第一个递减的位置。
     *
     * 为什么要找第一个递减的位置，因为如果不是递减的位置，说明遍历的序列已经是最大了。我们无法进行交换，使该序列变大。
     *
     * 因此，我们要找到一个拐点，使得遍历的序列当前不是最大值。
     *
     * 然后，将拐点与一个比它稍微大一点的数字进行替换。
     *
     *
     * 我们如何找到稍大一点的数字呢？
     *
     * 从右向左遍历，获取第一个比它大的数字，进行替换。
     *
     * 这样可以保证，拐点处的变动是最小的。
     *
     * 那么如何保证报点之后的数据是最小的呢？拐点之后，升序排序。
     *
     * OVER
     *
     * **/
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
