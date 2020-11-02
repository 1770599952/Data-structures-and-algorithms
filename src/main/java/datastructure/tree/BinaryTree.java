package datastructure.tree;

public class BinaryTree {

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
    }
}
