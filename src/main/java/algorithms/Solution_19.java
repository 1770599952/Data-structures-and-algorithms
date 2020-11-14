package algorithms;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 *给你两个数组，arr1 和 arr2，
 *
 * arr2 中的元素各不相同
 * arr2 中的每个元素都出现在 arr1 中
 * 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
 *
 *  
 *
 * 示例：
 *
 * 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 * 输出：[2,2,2,1,4,3,3,9,6,7,19]
 *  
 *
 * 提示：
 *
 * arr1.length, arr2.length <= 1000
 * 0 <= arr1[i], arr2[i] <= 1000
 * arr2 中的元素 arr2[i] 各不相同
 * arr2 中的每个元素 arr2[i] 都出现在 arr1 中
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/relative-sort-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * **/
public class Solution_19 {
    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        if (arr2 == null || arr2.length == 0) {
            return arr1;
        }

        int[] result = new int[arr1.length];
        int resultIndex = 0;

        Integer[] arr1Obj = new Integer[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            arr1Obj[i] = Integer.valueOf(arr1[i]);
        }

        // 1. 遍历arr2
        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < arr1Obj.length; j++) {
                if (arr1Obj[j] != null && arr1Obj[j] == arr2[i]) {
                    // 1.2 获取当前arr2[i]在A中出现的次数，存入结果数组.
                    result[resultIndex++] = arr2[i];
                    // 1.3 将当前arr2[i]在arr1中的元素置为null.
                    arr1Obj[j] = null;
                }
            }
        }
        // 2. 对arr1剩余的元素排序.
        List<Integer> numsList = Arrays.asList(arr1Obj);
        numsList = numsList.stream().filter(Objects::nonNull).collect(Collectors.toList());
        Collections.sort(numsList);

        // 3. arr1剩余的排序后元素添加到result中。
        for (int i = 0; i < numsList.size(); i++) {
            result[resultIndex++] = numsList.get(i);
        }
        return result;
    }


    public static void main(String[] args) {
        int[] arr1 = new int[]{2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
        int[] arr2 = new int[]{2, 1, 4, 3, 9, 6};

        System.out.println(relativeSortArray(arr1, arr2).toString());
    }
}
