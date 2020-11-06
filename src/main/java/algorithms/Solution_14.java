package algorithms;

import java.util.*;

/**
 * 给你一个整数数组 arr 。请你将数组中的元素按照其二进制表示中数字 1 的数目升序排序。
 * <p>
 * 如果存在多个数字二进制中 1 的数目相同，则必须将它们按照数值大小升序排列。
 * <p>
 * 请你返回排序后的数组。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [0,1,2,3,4,5,6,7,8]
 * 输出：[0,1,2,4,8,3,5,6,7]
 * 解释：[0] 是唯一一个有 0 个 1 的数。
 * [1,2,4,8] 都有 1 个 1 。
 * [3,5,6] 有 2 个 1 。
 * [7] 有 3 个 1 。
 * 按照 1 的个数排序得到的结果数组为 [0,1,2,4,8,3,5,6,7]
 * 示例 2：
 * <p>
 * 输入：arr = [1024,512,256,128,64,32,16,8,4,2,1]
 * 输出：[1,2,4,8,16,32,64,128,256,512,1024]
 * 解释：数组中所有整数二进制下都只有 1 个 1 ，所以你需要按照数值大小将它们排序。
 * 示例 3：
 * <p>
 * 输入：arr = [10000,10000]
 * 输出：[10000,10000]
 * 示例 4：
 * <p>
 * 输入：arr = [2,3,5,7,11,13,17,19]
 * 输出：[2,3,5,17,7,11,13,19]
 * 示例 5：
 * <p>
 * 输入：arr = [10,100,1000,10000]
 * 输出：[10,100,10000,1000]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-integers-by-the-number-of-1-bits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class Solution_14 {
    public static void main(String[] args) {
        int[] arr = {10000, 10000};
        int[] result = sortByBits(arr);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
        System.out.println(sortByBits(arr));
    }

    public static int[] sortByBits(int[] arr) {
        // 目标：将数据转化为二进制，根据二进制中1存在的数量进行升序排序。
        List<Entry> countList = new ArrayList<>();
        // 1.转换为二进制。获取1的数量
        for (int i = 0; i < arr.length; i++) {
            String binaryStr = Integer.toBinaryString(arr[i]);
            Entry entry = new Entry(arr[i], countSum(binaryStr));
            countList.add(entry);
        }
        // 2.根据value进行排序
        Collections.sort(countList, new Comparator<Entry>() {
            @Override
            public int compare(Entry o1, Entry o2) {
                if (o1.getValue() == o2.getValue()) {
                    return o1.getKey().compareTo(o2.getKey());
                } else {
                    return o1.getValue().compareTo(o2.getValue());
                }
            }
        });

        int[] result = new int[countList.size()];

        for (int i = 0; i < countList.size(); i++) {
            Entry entry = countList.get(i);
            result[i] = entry.getKey();
        }

        return result;
    }

    private static int countSum(String binaryStr) {
        int sum = 0;
        for (int i = 0; i < binaryStr.length(); i++) {
            if (binaryStr.charAt(i) == '1') {
                sum++;
            }
        }
        return sum;
    }

    static class Entry {

        public Integer key;
        public Integer value;

        public Entry(Integer key, Integer value) {
            this.key = key;
            this.value = value;
        }

        public void setKey(Integer key) {
            this.key = key;
        }

        public Integer getKey() {
            return key;
        }

        public Integer getValue() {
            return value;
        }

        public Integer setValue(Integer value) {
            this.value = value;
            return value;
        }

        @Override
        public boolean equals(Object o) {
            return false;
        }

        @Override
        public int hashCode() {
            return 0;
        }
    }

}
