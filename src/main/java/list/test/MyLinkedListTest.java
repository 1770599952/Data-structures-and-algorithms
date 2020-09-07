package list.test;

import list.MyLinkedList;

import java.util.Iterator;

public class MyLinkedListTest {
    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<Integer>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
//        list.remove(0);
//        list.remove(3);
//        list.printList();
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            Integer data = iterator.next();
            if (data.equals(2)) {
                iterator.remove();
                break;
            }
        }
        list.printList();
    }
}
