package algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * 字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。返回一个表示每个字符串片段的长度的列表。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：S = "ababcbacadefegdehijhklij"
 * 输出：[9,7,8]
 * 解释：
 * 划分结果为 "ababcbaca", "defegde", "hijhklij"。
 * 每个字母最多出现在一个片段中。
 * 像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-labels
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class Solution_5 {
    public static void main(String[] args) {
        System.out.println(partitionLabels("ababcbacadefegdehijhklij"));
    }

    public static List<Integer> partitionLabels(String S) {
        List<Integer> partResult = new ArrayList<Integer>();

        int index = 0;
        while (index < S.length()) {
            char c = S.charAt(index);
            int begin = S.indexOf(c);
            int last = S.lastIndexOf(c);

            for (int i = begin + 1; i <= last; i++) {
                char tmpC = S.charAt(i);
                if (S.lastIndexOf(tmpC) > last) {
                    last = S.lastIndexOf(tmpC);
                }
            }

            partResult.add(last - index + 1);
            index = last + 1;
        }

        return partResult;
    }
}
