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
     * 此题的本质是一个数列的排序问题，但是排序，增加了一个额外条件，提升了复杂性。
     * 我们分别拆解规则进行排序：
     *
     * H规则：
     * 我们按降序排序此数列，数字大的在左侧。
     * 如果数字相同，K大的在后面。
     * 因为K代表大于等于本数字的在本数字的数量，因此两个相同的数字，在后面的那个K肯定大。因此，K大的在后方。
     *
     * K规则：
     * 接下来，我们从左侧最大值开始进行额外条件的排序，
     * K等于几，就插入到下标为几的数列处。
     * 因为，对于每个数字而言，比当前数字大的数字已经排好序，
     * 因此，我们只需为当前数字找到，第K个大于它的数字，然后放到第K个数字之后即可。
     * 并不会影响，比它大的数字的排序。
     * 因为比它大的数字的排序规则与比它小的数字无关。
     *
     *
     *
     * 排序完：
     * [[7,0], [7,1], [6,1], [5,0], [5,2]，[4,4]]
     * 插入的过程：
     * 插入[7,0]：[[7,0]]
     * 插入[7,1]：[[7,0],[7,1]]
     * 插入[6,1]：[[7,0],[6,1],[7,1]]
     * 插入[5,0]：[[5,0],[7,0],[6,1],[7,1]]
     * 插入[5,2]：[[5,0],[7,0],[5,2],[6,1],[7,1]]
     * 插入[4,4]：[[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]]
     *
     * 作者：carlsun-2
     * 链接：https://leetcode-cn.com/problems/queue-reconstruction-by-height/solution/406du-shuo-shi-tan-xin-na-yao-wei-shi-yao-yong-tan/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * https://leetcode-cn.com/problems/queue-reconstruction-by-height/solution/406du-shuo-shi-tan-xin-na-yao-wei-shi-yao-yong-tan/
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
