package algorithms;

import java.util.*;

/**
 * 给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。例如，如果一个字符在每个字符串中出现 3 次，但不是 4 次，则需要在最终答案中包含该字符 3 次。
 * <p>
 * 你可以按任意顺序返回答案。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：["bella","label","roller"]
 * 输出：["e","l","l"]
 * 示例 2：
 * <p>
 * 输入：["cool","lock","cook"]
 * 输出：["c","o"]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-common-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class Solution_2 {
    public static void main(String[] args) {
        String[] init = {"bella", "label", "roller"};

        List<Map<Character, Integer>> list = new ArrayList<Map<Character, Integer>>();
        for (int i = 0; i < init.length; i++) {
            list.add(new HashMap<Character, Integer>());
            char[] elements = init[i].toCharArray();
            for (int j = 0; j < elements.length; j++) {
                Integer count = list.get(i).get(elements[j]);
                if (count == null) {
                    list.get(i).put(elements[j], 1);
                } else {
                    list.get(i).put(elements[j], list.get(i).get(elements[j]) + 1);
                }
            }
        }

        Map<Character, Integer> result = new HashMap<Character, Integer>();
        for (int i = 0; i < 1; i++) {
            Map<Character, Integer> cur = list.get(i);
            Set<Map.Entry<Character, Integer>> entries = cur.entrySet();
            Iterator<Map.Entry<Character, Integer>> iterator = entries.iterator();
            while (iterator.hasNext()) {
                Map.Entry<Character, Integer> entry = iterator.next();
                if (result.get(entry.getKey()) == null) {
                    result.put(entry.getKey(), entry.getValue());
                }

            }
        }

        Set<Map.Entry<Character, Integer>> entries = result.entrySet();
        Iterator<Map.Entry<Character, Integer>> iterator = entries.iterator();
        while (iterator.hasNext()) {
            Map.Entry<Character, Integer> entry = iterator.next();
            for (int i = 1; i < list.size(); i++) {
                Map<Character, Integer> cur = list.get(i);
                if (cur.get(entry.getKey()) == null) {
                    result.put(entry.getKey(), 0);
                } else if (cur.get(entry.getKey()) < entry.getValue()) {
                    result.put(entry.getKey(), cur.get(entry.getKey()));
                }
            }
        }
        System.out.println(list);
        System.out.println(result);
    }
}
