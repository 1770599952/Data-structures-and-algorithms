package algorithms;

import java.util.*;

/**我们有一个由平面上的点组成的列表 points。需要从中找出 K 个距离原点 (0, 0) 最近的点。

 （这里，平面上两点之间的距离是欧几里德距离。）

 你可以按任何顺序返回答案。除了点坐标的顺序之外，答案确保是唯一的。

  

 示例 1：

 输入：points = [[1,3],[-2,2]], K = 1
 输出：[[-2,2]]
 解释：
 (1, 3) 和原点之间的距离为 sqrt(10)，
 (-2, 2) 和原点之间的距离为 sqrt(8)，
 由于 sqrt(8) < sqrt(10)，(-2, 2) 离原点更近。
 我们只需要距离原点最近的 K = 1 个点，所以答案就是 [[-2,2]]。
 示例 2：

 输入：points = [[3,3],[5,-1],[-2,4]], K = 2
 输出：[[3,3],[-2,4]]
 （答案 [[-2,4],[3,3]] 也会被接受。）

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/k-closest-points-to-origin
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。**/
public class Solution_15 {
    public static void main(String[] args) {
        System.out.println(Math.abs(-1));
    }

    public static int[][] kClosest(int[][] points, int K) {
        Map<Integer, Double> map = new HashMap<>();

        for (int i = 0; i < points.length; i++) {
            int x = points[i][0];
            int y = points[i][1];
            double length = Math.sqrt(Math.abs(x) * Math.abs(x) + Math.abs(y) * Math.abs(y));
            map.put(i, length);
        }

        List<Map.Entry<Integer, Double>> list = new ArrayList<Map.Entry<Integer, Double>>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Double>>() {
            //升序排序
            @Override
            public int compare(Map.Entry<Integer, Double> o1,
                               Map.Entry<Integer, Double> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }

        });

        int[][] result = new int[K][2];
        for (int i = 0; i < K; i++) {
            Map.Entry<Integer, Double> entry = list.get(i);
            result[i][0] = points[entry.getKey()][0];
            result[i][1] = points[entry.getKey()][1];
        }

        return result;
    }
}
