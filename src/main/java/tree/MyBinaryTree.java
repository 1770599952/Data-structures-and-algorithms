package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉查找树
 */
public class MyBinaryTree {

    private TreeNode root;


    /**
     * 节点
     */
    public static class TreeNode {
        Integer data;
        TreeNode leftNode;
        TreeNode rightNode;
        TreeNode parentNode;
        TreeNode nextNode;

        public TreeNode(Integer data) {
            this.data = data;
        }

        public TreeNode(Integer data, TreeNode leftNode, TreeNode rightNode) {
            this.data = data;
            this.leftNode = leftNode;
            this.rightNode = rightNode;
        }

        public Integer getData() {
            return data;
        }

        public void setData(Integer data) {
            this.data = data;
        }

        public TreeNode getLeftNode() {
            return leftNode;
        }

        public void setLeftNode(TreeNode leftNode) {
            this.leftNode = leftNode;
        }

        public TreeNode getRightNode() {
            return rightNode;
        }

        public void setRightNode(TreeNode rightNode) {
            this.rightNode = rightNode;
        }

        public TreeNode getParentNode() {
            return parentNode;
        }

        public void setParentNode(TreeNode parentNode) {
            this.parentNode = parentNode;
        }

        public TreeNode getNextNode() {
            return nextNode;
        }

        public void setNextNode(TreeNode nextNode) {
            this.nextNode = nextNode;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "data=" + data +
                    '}';
        }
    }

    public void add(Integer data) {
        root = insert(root, data);
    }

    private TreeNode insert(TreeNode node, Integer data) {
        if (node == null) {
            return new TreeNode(data);
        }

        if (data > node.data) {
            node.rightNode = insert(node.rightNode, data);
            node.rightNode.parentNode = node;
        } else if (data < node.data) {
            node.leftNode = insert(node.leftNode, data);
            node.leftNode.parentNode = node;
        }

        return node;
    }

    public void listTree() {
        listTreeNode(root);
    }

    private void listTreeNode(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " " + node.getNextNode());
        listTreeNode(node.leftNode);
        listTreeNode(node.rightNode);
    }

    public Integer find(Integer data) {
        return findTreeNode(root, data).data;
    }

    public TreeNode findTreeNode(TreeNode node, Integer data) {
        if (data > node.data) {
            return findTreeNode(node.rightNode, data);
        } else if (data < node.data) {
            return findTreeNode(node.leftNode, data);
        } else if (node != null && node.data.equals(data)) {
            return node;
        }
        return null;
    }

    public boolean remove(Integer data) {
        TreeNode node = findTreeNode(root, data);
        if (node == null) {
            return false;
        }

        TreeNode parNode = node.parentNode;
        boolean isLeft = false;
        if (node.data.equals(parNode.leftNode.data)) {
            isLeft = true;
        }

        if (node.leftNode == null && node.rightNode == null) {
            if (isLeft) {
                parNode.leftNode = null;
            } else {
                parNode.rightNode = null;
            }
            return true;
        } else if (node.rightNode != null && node.leftNode == null) {
            if (isLeft) {
                parNode.leftNode = node.rightNode;
            } else {
                parNode.rightNode = node.rightNode;
            }
            return true;
        } else if (node.leftNode != null && node.rightNode == null) {
            if (isLeft) {
                parNode.leftNode = node.leftNode;
            } else {
                parNode.rightNode = node.leftNode;
            }
            return true;
        } else if (node.leftNode != null && node.rightNode != null) {
            TreeNode minNode = findMinTreeNode(node.rightNode);
            remove(minNode.data);
            node.data = minNode.data;
            return true;
        }

        return false;
    }

    private TreeNode findMinTreeNode(TreeNode node) {
        TreeNode minNode = node;
        while (minNode != null) {
            if (minNode.leftNode == null) {
                return minNode;
            }
            minNode = minNode.leftNode;
        }
        return minNode;
    }

    public TreeNode getRoot() {
        return root;
    }


    /**
     * 中序遍历
     * <p>
     * 1.先遍历左节点
     * 2.遍历根节点
     * 3.遍历右节点
     * <p>
     * 中序遍历的结果是递增有序的
     */
    public void ldrTree(TreeNode curNode, List<TreeNode> result) {
        if (curNode == null) {
            return;
        }
        ldrTree(curNode.leftNode, result);
        System.out.println(curNode);
        result.add(curNode);
        ldrTree(curNode.rightNode, result);
    }

    /**
     * 1.遍历根节点
     * 2.遍历左节点
     * 3.遍历右节点
     **/
    public List<Integer> preOrderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        preOrderTraversalVal(root, result);
        return result;
    }

    private void preOrderTraversalVal(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        result.add(root.data);
        preOrderTraversalVal(root.leftNode, result);
        preOrderTraversalVal(root.rightNode, result);
    }
}
