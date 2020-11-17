package algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 给出 R 行 C 列的矩阵，其中的单元格的整数坐标为 (r, c)，满足 0 <= r < R 且 0 <= c < C。
 * <p>
 * 另外，我们在该矩阵中给出了一个坐标为 (r0, c0) 的单元格。
 * <p>
 * 返回矩阵中的所有单元格的坐标，并按到 (r0, c0) 的距离从最小到最大的顺序排，其中，两单元格(r1, c1) 和 (r2, c2) 之间的距离是曼哈顿距离，|r1 - r2| + |c1 - c2|。（你可以按任何满足此条件的顺序返回答案。）
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：R = 1, C = 2, r0 = 0, c0 = 0
 * 输出：[[0,0],[0,1]]
 * 解释：从 (r0, c0) 到其他单元格的距离为：[0,1]
 * 示例 2：
 * <p>
 * 输入：R = 2, C = 2, r0 = 0, c0 = 1
 * 输出：[[0,1],[0,0],[1,1],[1,0]]
 * 解释：从 (r0, c0) 到其他单元格的距离为：[0,1,1,2]
 * [[0,1],[1,1],[0,0],[1,0]] 也会被视作正确答案。
 * 示例 3：
 * <p>
 * 输入：R = 2, C = 3, r0 = 1, c0 = 2
 * 输出：[[1,2],[0,2],[1,1],[0,1],[1,0],[0,0]]
 * 解释：从 (r0, c0) 到其他单元格的距离为：[0,1,1,2,2,3]
 * 其他满足题目要求的答案也会被视为正确，例如 [[1,2],[1,1],[0,2],[1,0],[0,1],[0,0]]。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/matrix-cells-in-distance-order
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class Solution_21 {
    public static void main(String[] args) {
        int[][] result = allCellsDistOrder(1,2,0,0);
        System.out.println(result);
    }

    public static int[][] allCellsDistOrder(int R, int C, int r0, int c0) {

        List<RC> res = new ArrayList<>();
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                int num = Math.abs(r0 - r) + Math.abs(c0 - c);
                RC rc = new RC(r, c, num);
                res.add(rc);
            }
        }
        Collections.sort(res, new Comparator<RC>() {
            @Override
            public int compare(RC o1, RC o2) {
                return o1.getResult() - o2.getResult();
            }
        });

        int[][] result = new int[res.size()][2];

        for (int i = 0; i < res.size(); i++) {
            result[i][0] = res.get(i).getR();
            result[i][1] = res.get(i).getC();
        }
        return result;
    }
}

class RC {
    int r;
    int c;
    int result;

    public RC(int r, int c, int result) {
        this.r = r;
        this.c = c;
        this.result = result;
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }
}
