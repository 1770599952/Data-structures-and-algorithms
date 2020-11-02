package datastructure.map.test;

import datastructure.map.MyHashMap;

import java.util.Map;

public class MyHashMapTest {
    public static void main(String[] args) {
        MyHashMap<Integer, Integer> hashMap = new MyHashMap<Integer, Integer>();
        for (int i = 0; i < 16; i++) {
            hashMap.put(i, i);
        }
        System.out.println(hashMap.size());
        Map.Entry<Integer,Integer>[] entries = hashMap.getTables();
        System.out.println(entries);
        System.out.println(hashMap.get(1));
    }
}
