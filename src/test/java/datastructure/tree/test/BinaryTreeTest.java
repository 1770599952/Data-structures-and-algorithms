package datastructure.tree.test;

import datastructure.tree.BinaryTree;

public class BinaryTreeTest {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        for (int i = 0; i < 10; i++) {
            tree.add(i);
        }
        tree.printTree();
    }
}
