package list.test;

import list.LinkedList;

public class LinkedListTest {
    public static void main(String[] args) {
        LinkedList linkedList1 = new LinkedList();

        for (int i = 0; i < 100; i++) {
            linkedList1.add(i);
        }

        linkedList1.list();

        System.out.println();

        for (int i = 0; i < 100; i++) {
            linkedList1.remove(i);
        }

        linkedList1.list();
    }
}