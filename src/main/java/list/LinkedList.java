package list;


public class LinkedList {

    private Integer size = Integer.valueOf(0);
    private Node head;
    private Node tail;

    public void add(Integer data) {
        if (head == null) {
            head = new Node(data);
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new Node(data);
        size++;
    }

    public Integer remove(Integer i) {

        if (head == null) {
            return null;
        }

        // 1.遍历链表，找到该元素
        Node current = head;
        Node preNode = null;

        if (head.data == (int) i) {
            Integer removeData = head.data;
            head = head.next;
            size--;
            return removeData;
        }

        while (current != null) {
            if (current.data == (int) i) {
                // 2.该元素前置节点next元素指向当前元素next节点
                preNode.next = current.next;
                current = null;
                size--;
                return current.data;
            }
            preNode = current;
            current = current.next;
        }

        return null;
    }

    public void list() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }

    public int size() {
        return size;
    }

    private static class Node {
        Integer data;
        Node next;

        public Node(Integer data) {
            this.data = data;
        }
    }

}
