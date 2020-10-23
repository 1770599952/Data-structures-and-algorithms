package list.test;

import list.MyArrayList;

import java.util.Iterator;

public class Learn_2 {
    public static void main(String[] args) {
        MyArrayList<Integer> list = new MyArrayList<Integer>();
        for (int i = 0; i < 20; i++) {
            list.add(i);
        }

        list.remove(7);

        Iterator<Integer> iterator = list.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }
}
