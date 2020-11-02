package datastructure.map;

import java.util.concurrent.locks.ReentrantLock;

/**
 * https://www.ibm.com/developerworks/cn/java/java-lo-concurrenthashmap/index.html
 *
 * @param <K>
 * @param <V>
 */
public class MyConcurrentHashMap<K, V> {

    static final int DEFAULT_INITIAL_CAPACITY = 4;
    static final int DEFAULT_CONCURRENCY_LEVEL = 16;
    private Segment<K, V>[] segments;

    static final class HashEntry<K, V> {
        final K key;
        final int hash;
        volatile V value;
        final HashEntry<K, V> next;

        HashEntry(K key, int hash, HashEntry<K, V> next, V value) {
            this.key = key;
            this.hash = hash;
            this.next = next;
            this.value = value;
        }
    }

    private static class Segment<K, V> extends ReentrantLock {
        private HashEntry[] table;
        transient volatile int count;
    }

    private static int hash(int h) {
        // Spread bits to regularize both segment and index locations,
        // using variant of single-word Wang/Jenkins hash.
        h += (h << 15) ^ 0xffffcd7d;
        h ^= (h >>> 10);
        h += (h << 3);
        h ^= (h >>> 6);
        h += (h << 2) + (h << 14);
        return h ^ (h >>> 16);
    }

    private int indexFor(int hash, int length) {
        return hash & (length - 1);
    }

    public MyConcurrentHashMap() {
        segments = new Segment[DEFAULT_CONCURRENCY_LEVEL];
        for (int i = 0; i < segments.length; i++) {
            segments[i] = new Segment<K, V>();
            segments[i].table = new HashEntry[DEFAULT_INITIAL_CAPACITY];
        }
    }

    public V put(K key, V value) {
        if (key == null || value == null) {
            throw new RuntimeException("key or value is null");
        }
        int hash = hash(key.hashCode());
        int segmentIndex = indexFor(hash, segments.length);
        Segment<K, V> lock = segments[segmentIndex];
        try {
            lock.lock();
            int index = indexFor(hash, lock.table.length);
            HashEntry<K, V> oldFirstEntry = lock.table[index];
            if (oldFirstEntry == null) {
                HashEntry<K, V> newEntry = new HashEntry<K, V>(key, hash, null, value);
                lock.table[index] = newEntry;
            } else {
                HashEntry<K, V> curEntry = oldFirstEntry;
                while (curEntry != null) {
                    if (curEntry.key.equals(key)) {
                        curEntry.value = value;
                        return value;
                    }
                    curEntry = curEntry.next;
                }
                HashEntry<K, V> newEntry = new HashEntry<K, V>(key, hash, oldFirstEntry, value);
                lock.table[index] = newEntry;
            }
            return value;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return null;
    }

    public V get(K key) {
        if (key == null) {
            throw new RuntimeException("key is null");
        }
        int hash = hash(key.hashCode());
        int segmentIndex = indexFor(hash, segments.length);
        Segment<K, V> lock = segments[segmentIndex];
        int index = indexFor(hash, lock.table.length);
        HashEntry<K, V> oldFirstEntry = lock.table[index];
        HashEntry<K, V> curEntry = oldFirstEntry;
        while (curEntry != null) {
            if (curEntry.key.equals(key)) {
                return curEntry.value;
            }
            curEntry = curEntry.next;
        }
        return null;
    }

    private HashEntry<K, V> getEntry(K key) {
        if (key == null) {
            throw new RuntimeException("key is null");
        }
        int hash = hash(key.hashCode());
        int segmentIndex = indexFor(hash, segments.length);
        Segment<K, V> lock = segments[segmentIndex];
        int index = indexFor(hash, lock.table.length);
        lock.lock();
        HashEntry<K, V> oldFirstEntry = lock.table[index];
        HashEntry<K, V> curEntry = oldFirstEntry;
        while (curEntry != null) {
            if (curEntry.key.equals(key)) {
                return curEntry;
            }
            curEntry = curEntry.next;
        }
        return null;
    }

    public boolean remove(K key) {
        HashEntry<K, V> removeEntry = null;
        Segment<K, V> lock = null;
        try {
            if (key == null) {
                throw new RuntimeException("key is null");
            }
            int hash = hash(key.hashCode());
            int segmentIndex = indexFor(hash, segments.length);
            lock = segments[segmentIndex];
            int index = indexFor(hash, lock.table.length);
            lock.lock();
            HashEntry<K, V> oldFirstEntry = lock.table[index];
            HashEntry<K, V> curEntry = oldFirstEntry;
            while (curEntry != null) {
                if (curEntry.key.equals(key)) {
                    removeEntry = curEntry;
                    break;
                }
                curEntry = curEntry.next;
            }
            HashEntry<K, V> newFirst = removeEntry.next;
            if (removeEntry != null) {
                for (HashEntry<K, V> moveEntry = oldFirstEntry; moveEntry != removeEntry; moveEntry = moveEntry.next) {
                    newFirst = new HashEntry<K, V>(moveEntry.key, moveEntry.hash,
                            newFirst, moveEntry.value);
                }
                lock.table[index] = newFirst;
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return false;
    }

}
