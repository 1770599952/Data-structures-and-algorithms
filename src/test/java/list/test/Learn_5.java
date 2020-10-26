package list.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 请判断一个链表是否为回文链表。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 * <p>
 * 输入: 1->2->2->1
 * 输出: true
 **/
public class Learn_5 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(1);
        list.add(2);

        int minPos = list.size() / 2;

        Stack<Integer> stack = new Stack<Integer>();

        for (int i = minPos; i < list.size(); i++) {
            stack.push(list.get(i));
        }

        for (int i = 0; i < minPos; i++) {
            if (list.get(i) != stack.pop()) {
                System.out.println("不是回文链表");
                return;
            }
        }

        System.out.println("是回文链表");


    }
}
