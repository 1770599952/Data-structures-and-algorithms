package datastructure.list;

/**
 * 链表反转算法
 */
public class LinkedListReserve {

    private static Node head;

    public static void reserveLinkedList() {
        if (head == null || head.next == null) {
            return;
        }

        Node p1 = head;
        Node p2 = head.next;
        Node p3 = null;

        while (p2 != null) {
            p3 = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = p3;
        }
        // 将过的头节点next引用清空
        head.next = null;
        head = p1;
    }

    private static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        Node[] list = new Node[5];
        for (int i = 0; i < list.length; i++) {
            list[i] = new Node(i);
            if (i != 0) {
                list[i - 1].next = list[i];
            }
        }
        head = list[0];
        System.out.println("逆序前链表：");
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i].data + " ");
        }
        System.out.println();
        System.out.println("逆序后链表");
        LinkedListReserve.reserveLinkedList();
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }
}
