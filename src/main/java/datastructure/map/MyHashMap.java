package datastructure.map;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class MyHashMap<K, V> implements Map<K, V> {

    Entry[] tables = new Entry[16];
    private int size;

    private static class Entry<K, V> implements Map.Entry<K, V> {
        int hash;
        K key;
        V value;
        Entry next;

        public Entry() {
        }

        public Entry(int hash, K key, V value, Entry next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V value) {
            this.value = value;
            return value;
        }

        public final int hashCode() {
            return (key == null ? 0 : key.hashCode()) ^
                    (value == null ? 0 : value.hashCode());
        }

        public final String toString() {
            return getKey() + "=" + getValue();
        }
    }

    public MyHashMap() {
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean containsKey(Object key) {
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    @Override
    public V get(Object key) {
        int hash = hash(key.hashCode());
        int i = indexFor(hash, tables.length);

        Entry<K, V> cur = tables[i];
        while (cur != null) {
            if (cur.key.equals(key)) {
                return cur.value;
            }
            cur = cur.next;
        }

        return null;
    }

    @Override
    public V put(K key, V value) {
        // 1.hash获取所在的数组位置
        int hash = hash(key.hashCode());
        Entry entry = new Entry(hash, key, value, null);
        int i = indexFor(hash, tables.length);

        // 2.判断所在数组位置是否为空，如果空，直接插入
        if (tables[i] == null) {
            tables[i] = entry;
        } else {
            // 如果不为空，则进行遍历，
            // 如果元素过去已经存在，则将值进行替换
            // 如果元素过去不存在，添加到链表结尾
            Entry<K, V> old = tables[i];
            while (old != null) {
                if (old.key.equals(key)) {
                    old.value = value;
                    return old.value;
                }
                if (old.next == null) {
                    old.next = entry;
                    return value;
                }
                old = old.next;
            }
        }
        size++;
        return value;
    }

    private int indexFor(int hash, int length) {
        return hash & (length - 1);
    }

    static int hash(int h) {
        h ^= (h >>> 20) ^ (h >>> 12);
        return h ^ (h >>> 7) ^ (h >>> 4);
    }

    @Override
    public V remove(Object key) {
        return null;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Set<K> keySet() {
        return null;
    }

    @Override
    public Collection<V> values() {
        return null;
    }

    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        return null;
    }

    public Entry[] getTables() {
        return tables;
    }

    public void setTables(Entry[] tables) {
        this.tables = tables;
    }
}
