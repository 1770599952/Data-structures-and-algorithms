package tree.test;

import tree.AVLBinaryTree;

public class AVLBinaryTreeTest {
    public static void main(String[] args) {
        AVLBinaryTree avlTree = new AVLBinaryTree();
        // 右旋转
        int[] arrRight = new int[]{10, 7, 11, 6, 8, 5};
        // 左旋转
        int[] arrLeft = new int[]{7, 6, 9, 8, 10, 12};
        // 双旋转 -- 先左 转后右转
        int[] arrLR = new int[]{9, 6, 10, 5, 7, 8};
        // 双旋转 -- 先右转后左转
        int[] arrRL = new int[]{7, 6, 12, 8, 13, 10};

        int[] arr = arrRL;
        for (int i = 0; i < arr.length; i++) {
            avlTree.add(arr[i]);
        }
        System.out.println("当前树的高度为:" + avlTree.getHeight());
        avlTree.printTree();
    }
}
