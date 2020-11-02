package datastructure.list;

/**
 * 判断链表是否有环算法 - 1
 */
public class LinkedListRecycle {
    public static void main(String[] args) {

        Node[] nodeArr = new Node[6];
        for (int i = 0; i < nodeArr.length; i++) {
            nodeArr[i] = new Node(i);
        }
        for (int i = 0; i < nodeArr.length - 1; i++) {
            nodeArr[i].next = nodeArr[i + 1];
        }
        nodeArr[5].next = nodeArr[0];

        Node p1 = nodeArr[0];
        Node p2 = p1;
        while (p2.next.next != null) {
            p2 = p2.next.next;
            p1 = p1.next;
            if (p2 == p1) {
                System.out.println("链表有环!");
                break;
            }
        }

        for (int i = 0; i < nodeArr.length; i++) {
            System.out.print(nodeArr[i].data + " ");
        }
    }

    private static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

}
