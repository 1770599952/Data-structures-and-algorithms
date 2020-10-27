package tree.test;

import org.junit.Before;
import org.junit.Test;
import tree.MyBinaryTree;

public class MyBinaryTreeTest_4 {

    @Test
    @Before
    public void init() {
        MyBinaryTree tree = new MyBinaryTree();

        tree.add(6);
        tree.add(4);
        tree.add(3);
        tree.add(5);
        tree.add(8);
        tree.add(7);
        tree.add(9);

        tree.listTree();
        System.out.println();

        System.out.println(tree.preOrderTraversal(tree.getRoot()));
    }
}
