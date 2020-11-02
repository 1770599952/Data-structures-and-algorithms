package datastructure.list.test;

import datastructure.list.LinkedList;

public class Learn_3 {
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
