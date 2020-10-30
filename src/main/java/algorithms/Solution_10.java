package algorithms;

/**
 * 给定一个包含 0 和 1 的二维网格地图，其中 1 表示陆地 0 表示水域。
 * <p>
 * 网格中的格子水平和垂直方向相连（对角线方向不相连）。整个网格被水完全包围，但其中恰好有一个岛屿（或者说，一个或多个表示陆地的格子相连组成的岛屿）。
 * <p>
 * 岛屿中没有“湖”（“湖” 指水域在岛屿内部且不和岛屿周围的水相连）。格子是边长为 1 的正方形。网格为长方形，且宽度和高度均不超过 100 。计算这个岛屿的周长。
 * <p>
 *  
 * <p>
 * 示例 :
 * <p>
 * 输入:
 * [[0,1,0,0],
 * [1,1,1,0],
 * [0,1,0,0],
 * [1,1,0,0]]
 * <p>
 * 输出: 16
 * <p>
 * 解释: 它的周长是下面图片中的 16 个黄色的边：
 * <p>
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/island-perimeter
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class Solution_10 {
    public static void main(String[] args) {
        int[][] grid = {{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}};
        System.out.println(islandPerimeter(grid));
    }

    public static int islandPerimeter(int[][] grid) {

        int result = 0;

        int rows = grid.length;
        int cols = grid[0].length;

        int ROAD = 1;
        int WATER = 0;

        for (int curRow = 0; curRow < rows; curRow++) {
            for (int curCol = 0; curCol < cols; curCol++) {
                if (grid[curRow][curCol] == ROAD) {

                    // 上边界
                    if (curRow - 1 >= 0) {
                        if (grid[curRow - 1][curCol] == WATER) {
                            result++;
                        }
                    } else {
                        result++;
                    }

                    // 右边界
                    if (curCol + 1 < cols) {
                        if (grid[curRow][curCol + 1] == WATER) {
                            result++;
                        }
                    } else {
                        result++;
                    }

                    // 下边界
                    if (curRow + 1 < rows) {
                        if (grid[curRow + 1][curCol] == WATER) {
                            result++;
                        }
                    } else {
                        result++;
                    }

                    // 左边界
                    if (curCol - 1 >= 0) {
                        if (grid[curRow][curCol - 1] == WATER) {
                            result++;
                        }
                    } else {
                        result++;
                    }
                }
            }
        }

        return result;
    }
}
