package algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution_1 {
    public static void main(String[] args) {
        List<Integer> number1 = new ArrayList<Integer>();
        number1.add(2);
        number1.add(4);
        number1.add(3);
        List<Integer> number2 = new ArrayList<Integer>();
        number2.add(5);
        number2.add(6);
        // number2.add(9);

        List<Integer> result = addTwoNum(number1, number2);
        Collections.reverse(result);
        System.out.println(result);


    }

    private static List<Integer> addTwoNum(List<Integer> number1, List<Integer> number2) {
        List<Integer> result = new ArrayList<Integer>();

        int size = number2.size();
        if (number1.size() > number2.size()) {
            size = number1.size();
        }

        int left = 0;

        for (int i = 0; i < size; i++) {
            int num1 = i >= number1.size() ? 0 : number1.get(i);
            int num2 = i >= number2.size() ? 0 : number2.get(i);

            int tmp = num1 + num2;

            if (left > 0) {
                tmp = tmp + 1;
                if (tmp >= 10) {
                    left = 1;
                    tmp = tmp - 10;
                    result.add(tmp);
                } else {
                    left = 0;
                    result.add(tmp);
                }

            } else {
                if (tmp >= 10) {
                    left = 1;
                    tmp = tmp - 10;
                    result.add(tmp);
                } else {
                    result.add(tmp);
                }
            }

        }
        if (left != 0) {
            result.add(left);
        }

        return result;
    }
}
