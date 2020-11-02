package datastructure.tree.test;

import org.junit.Before;
import org.junit.Test;
import datastructure.tree.MyBinaryTree;

import java.util.ArrayList;
import java.util.List;

/*给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。

百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”

例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]
 

示例 1:

输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
输出: 6
解释: 节点 2 和节点 8 的最近公共祖先是 6。
示例 2:

输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
输出: 2
解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。
 

说明:

所有节点的值都是唯一的。
p、q 为不同节点且均存在于给定的二叉搜索树中。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/
public class MyBinaryTreeTest_1 {
    MyBinaryTree tree = new MyBinaryTree();

    @Before
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
        tree.ldrTree(tree.getRoot(),result);
        System.out.println(result);
    }

    @Test
    public void lowestCommonAncestor() {
        MyBinaryTree.TreeNode root = tree.getRoot();
        MyBinaryTree.TreeNode p = new MyBinaryTree.TreeNode(3);
        MyBinaryTree.TreeNode q = new MyBinaryTree.TreeNode(5);

        List<MyBinaryTree.TreeNode> pPath = getPath(root, p);
        System.out.println(pPath);
        List<MyBinaryTree.TreeNode> qPath = getPath(root, q);
        System.out.println(qPath);

        MyBinaryTree.TreeNode result = null;
        for (int i = 0; i < pPath.size() && i < qPath.size(); i++) {
            if (pPath.get(i).getData() == qPath.get(i).getData()) {
                result = pPath.get(i);
            }else {
                break;
            }
        }

        System.out.println(result);

    }

    private List<MyBinaryTree.TreeNode> getPath(MyBinaryTree.TreeNode root, MyBinaryTree.TreeNode target) {
        List<MyBinaryTree.TreeNode> targetParPath = new ArrayList<MyBinaryTree.TreeNode>();
        MyBinaryTree.TreeNode curNode = root;

        while (curNode.getData() != target.getData()) {
            targetParPath.add(curNode);
            if (target.getData() > curNode.getData()) {
                curNode = curNode.getRightNode();
            } else if (target.getData() < curNode.getData()) {
                curNode = curNode.getLeftNode();
            }
        }

        targetParPath.add(curNode);

        return targetParPath;
    }

}
