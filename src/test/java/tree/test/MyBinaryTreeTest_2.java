package tree.test;

import org.junit.Test;
import tree.MyBinaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。
 *  * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：
 * <p>
 * 1
 * \
 * 3
 * /
 * 2
 * <p>
 * 输出：
 * 1
 * <p>
 * 解释：
 * 最小绝对差为 1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。
 *  
 * <p>
 * 提示：
 * <p>
 * 树中至少有 2 个节点。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class MyBinaryTreeTest_2 {
    MyBinaryTree tree = new MyBinaryTree();

    @Test
    public void init() {
        tree.add(6);
        tree.add(2);
        tree.add(8);
        tree.add(0);
        tree.add(4);
        tree.add(7);
        tree.add(9);
        tree.add(3);
        tree.add(5);

        tree.listTree();
        System.out.println();
        List<MyBinaryTree.TreeNode> result = new ArrayList<MyBinaryTree.TreeNode>();
        tree.ldrTree(tree.getRoot(), result);
        System.out.println(result);

        Integer minData = null;
        for (int i = 1; i < result.size(); i++) {
            if (minData == null) {
                minData = result.get(i + 1).getData() - result.get(i).getData();
            } else {
                if (result.get(i).getData() - result.get(i - 1).getData() < minData) {
                    minData = result.get(i + 1).getData() - result.get(i).getData();
                }
            }
        }

        System.out.println(minData);

    }


}
