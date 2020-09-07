package tree;

/**
 * AVL树
 */
public class AVLBinaryTree {

    private TreeNode root;

    public TreeNode add(Integer data) {
        return root = insert(data, root);
    }

    private TreeNode insert(Integer data, TreeNode node) {
        if (node == null) {
            return new TreeNode(data);
        }

        if (data > node.data) {
            node.rightNode = insert(data, node.rightNode);
        } else if (data < node.data) {
            node.leftNode = insert(data, node.leftNode);
        }

        if (node.leftNode != null && node.rightNode != null && node.leftNode.height() - node.rightNode.height() >= 2) {
            if (node.leftNode != null && node.leftNode.leftHeight() < node.leftNode.rightHeight()) {
                node.leftNode.leftRotate();
            }
            node.rightRotate();
        }

        if (node.leftNode != null && node.rightNode != null && node.rightNode.height() - node.leftNode.height() >= 2) {
            if (node.rightNode != null && node.rightNode.leftHeight() > node.rightNode.rightHeight()) {
                node.rightNode.rightRotate();
            }
            node.leftRotate();
        }

        return node;
    }

    private TreeNode findTreeNode(Integer data) {
        TreeNode current = root;
        if (data > current.data) {
            current = findTreeNode(current.rightNode.data);
        } else if (data < current.data) {
            current = findTreeNode(current.leftNode.data);
        }
        return current;
    }

    public void remove(Integer data) {
        root = remove(data, root);
    }

    private TreeNode remove(Integer data, TreeNode root) {
        return null;
    }

    public Integer get(Integer data) {
        return findTreeNode(data).data;
    }

    public void printTree() {
        printTreeNode(root);
    }

    private void printTreeNode(TreeNode node) {
        if (node == null)
            return;
        System.out.print(node.data + " ");
        printTreeNode(node.leftNode);
        printTreeNode(node.rightNode);
    }

    public int getHeight() {
        return root.height();
    }

    private static class TreeNode {
        Integer data;
        TreeNode leftNode;
        TreeNode rightNode;

        public TreeNode(Integer data) {
            this.data = data;
        }

        public TreeNode(Integer data, TreeNode leftNode, TreeNode rightNode) {
            this.data = data;
            this.leftNode = leftNode;
            this.rightNode = rightNode;
        }

        public int height() {
            return Math.max(leftNode == null ? 0 : leftNode.height(), rightNode == null ? 0 : rightNode.height()) + 1;
        }

        /**
         * 右旋转
         */
        private void rightRotate() {
            TreeNode newNode = new TreeNode(data);
            newNode.rightNode = rightNode;
            newNode.leftNode = leftNode.rightNode;
            this.data = leftNode.data;
            this.leftNode = this.leftNode.leftNode;
            rightNode = newNode;
        }

        /**
         * 左旋转
         */
        private void leftRotate() {
            TreeNode newNode = new TreeNode(data);
            newNode.leftNode = leftNode;
            newNode.rightNode = this.rightNode.leftNode;
            this.data = this.rightNode.data;
            this.rightNode = this.rightNode.rightNode;
            leftNode = newNode;
        }

        public int leftHeight() {
            return leftNode == null ? 0 : leftNode.height();
        }

        public int rightHeight() {
            return rightNode == null ? 0 : rightNode.height();
        }
    }
}
