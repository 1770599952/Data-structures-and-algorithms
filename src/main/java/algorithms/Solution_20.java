package algorithms;


import java.util.LinkedList;

/**
 * 假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对(h, k)表示，其中h是这个人的身高，k是排在这个人前面且身高大于或等于h的人数。 编写一个算法来重建这个队列。
 * <p>
 * 注意：
 * 总人数少于1100人。
 * <p>
 * 示例
 * <p>
 * 输入:
 * [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 * <p>
 * 输出:
 * [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/queue-reconstruction-by-height
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class Solution_20 {
    public static void main(String[] args) {
        int[][] people = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        System.out.println(reconstructQueue(people));
    }

    /**
     * 思路：
     *
     *
     *
     *
     *
     * **/
    public static int[][] reconstructQueue(int[][] people) {
        int[][] result = new int[people.length][2];
        if (people == null || people.length == 0) {
            return result;
        }
        LinkedList<People> peopleLinkedList = new LinkedList();
        // 1.根据身高进行降序排序。 如果身高相同，K大的在后面。
        sort(people);
        // 2.按序插入。
        for (int i = 0; i < people.length; i++) {
            if (peopleLinkedList.size() == 0) {
                peopleLinkedList.add(new People(people[i][0], people[i][1]));
            } else {
                peopleLinkedList.add(people[i][1], new People(people[i][0], people[i][1]));
            }
        }

        for (int i = 0; i < peopleLinkedList.size(); i++) {
            result[i][0] = peopleLinkedList.get(i).getH();
            result[i][1] = peopleLinkedList.get(i).getK();
        }
        return result;
    }

    private static void sort(int[][] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i][0] < nums[j][0]) {
                    swap(nums, i, j);
                } else if (nums[i][0] == nums[j][0]) {
                    if (nums[i][1] > nums[j][1]) {
                        swap(nums, i, j);
                    }
                }
            }
        }
    }

    private static void swap(int[][] nums, Integer i, Integer index) {
        int[] temp = nums[i];
        nums[i] = nums[index];
        nums[index] = temp;
    }
}

class People {
    int h;
    int k;

    public People(int h, int k) {
        this.h = h;
        this.k = k;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public int getK() {
        return k;
    }

    public void setK(int k) {
        this.k = k;
    }
}