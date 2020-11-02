package datastructure.tree.test;

import org.junit.Before;
import org.junit.Test;
import datastructure.tree.MyBinaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个完美二叉树，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
 * <p>
 * struct Node {
 * int val;
 * Node *left;
 * Node *right;
 * Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 * <p>
 * 初始状态下，所有 next 指针都被设置为 NULL。
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class MyBinaryTreeTest_3 {

    MyBinaryTree tree = new MyBinaryTree();

    @Test
    public void main() {

        // 此题的本质含义在意，分别遍历每一层的数据，形成链表。
        // 那么如何获取每一层的数据呢，遍历上一层所有节点，将其的子节点依次添加到链表中。

        Queue<MyBinaryTree.TreeNode> treeNodesQueue = new LinkedList<MyBinaryTree.TreeNode>();
        treeNodesQueue.add(tree.getRoot());

        while (!treeNodesQueue.isEmpty()) {
            int size = treeNodesQueue.size();
            for (int i = 0; i < size; i++) {
                MyBinaryTree.TreeNode node = treeNodesQueue.poll();
                if (i < size - 1) {
                    node.setNextNode(treeNodesQueue.peek());
                }

                if (node.getLeftNode() != null) {
                    treeNodesQueue.add(node.getLeftNode());
                }

                if (node.getRightNode() != null) {
                    treeNodesQueue.add(node.getRightNode());
                }
            }
        }

        tree.listTree();

    }

    @Test
    @Before
    public void init() {
        tree.add(6);
        tree.add(4);
        tree.add(3);
        tree.add(5);
        tree.add(8);
        tree.add(7);
        tree.add(9);

        tree.listTree();
        System.out.println();
    }

}
