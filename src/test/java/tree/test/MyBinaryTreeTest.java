package tree.test;

import tree.MyBinaryTree;

public class MyBinaryTreeTest {
    public static void main(String[] args) {
        MyBinaryTree tree = new MyBinaryTree();
        tree.add(4);
        tree.add(2);
        tree.add(5);
        tree.add(6);
        tree.add(1);
        tree.add(3);
        tree.listTree();
        System.out.println(tree.remove(2));
        tree.listTree();
    }
}
