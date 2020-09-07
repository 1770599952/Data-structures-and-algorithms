package list;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class MyArrayList<T> implements Collection<T> {

    private static final int DEFAULT_CAPACITY = 10;
    private Object[] table;
    private int size;

    public MyArrayList() {
        table = new Object[DEFAULT_CAPACITY];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object obj) {
        T searchElement = findElement(obj);
        return searchElement == null ? false : true;
    }

    private T findElement(Object obj) {
        for (Object data : table) {
            if (data.equals(obj)) {
                return (T) data;
            }
        }
        return null;
    }

    @Override
    public Iterator iterator() {
        return new ArrayListIterator();
    }

    private class ArrayListIterator implements Iterator {

        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < size;
        }

        @Override
        public Object next() {
            return table[currentIndex++];
        }

        @Override
        public void remove() {
            MyArrayList.this.remove(table[currentIndex]);
        }
    }

    @Override
    public Object[] toArray() {
        return table;
    }

    @Override
    public boolean add(T data) {
        ensureCapacity(size + 1);
        table[size] = data;
        size++;
        return false;
    }

    private void ensureCapacity(int minCapacity) {
        if (minCapacity <= table.length)
            return;
        table = Arrays.copyOf(table, minCapacity);
    }

    @Override
    public boolean remove(Object obj) {
        Integer removeIndex = null;
        for (int i = 0; i < table.length; i++) {
            if (table[i].equals(obj)) {
                table[i] = table[i + 1];
                removeIndex = i;
                break;
            }
        }
        if (removeIndex == null || size() == 0)
            return false;
        for (int i = removeIndex; i < table.length - 1; i++) {
            table[i] = table[i + 1];
        }
        return true;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public void clear() {
        table = null;
        size = 0;
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }
}
