package list.test;

import list.MyArrayList_1;

public class Learn_1 {
    public static void main(String[] args) {
        MyArrayList_1<Integer> list = new MyArrayList_1<Integer>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        list.remove(0);
        list.set(1, 10);

        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
    }
}
