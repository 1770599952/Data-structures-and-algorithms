package map.test;

import map.MyConcurrentHashMap;

public class MyConcurrentHashMapTest {
    public static void main(String[] args) {
        MyConcurrentHashMap<Integer, Integer> map = new MyConcurrentHashMap<Integer, Integer>();
        for (int i = 0; i < 10; i++) {
            map.put(i, i);
        }
        for (int i = 0; i < 10; i++) {
            System.out.print(map.get(i) + " ");
        }
        map.remove(5);
        System.out.println();
        for (int i = 0; i < 10; i++) {
            System.out.print(map.get(i) + " ");
        }

    }
}
