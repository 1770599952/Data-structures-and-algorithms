package datastructure.list;

import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;

public class MyArrayList_1<E> implements Collection<E> {

    private Object[] datas;
    private int size;
    private int modCount;

    public MyArrayList_1() {
        datas = new Object[10];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return new MyArrayListIterator();
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(E e) {
        ensureCapacity(size);
        datas[size++] = e;
        return true;
    }

    private void ensureCapacity(int size) {
        if (datas.length <= size) {
            Object[] newTables = new Object[datas.length * 2];
            for (int i = 0; i < datas.length; i++) {
                newTables[i] = datas[i];
            }
            datas = newTables;
        }
    }

    @Override
    public boolean remove(Object obj) {
        Integer removeIndex = null;
        for (int i = 0; i < datas.length; i++) {
            if (datas[i].equals(obj)) {
                removeIndex = i;
                break;
            }
        }
        if (removeIndex == null)
            return false;
        for (int i = removeIndex; i < datas.length - 1; i++) {
            datas[i] = datas[i + 1];
        }
        return true;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    public E get(int index) {
        return (E) datas[index];
    }

    public void set(int index, E data) {
        datas[index] = data;
    }

    private class MyArrayListIterator implements Iterator<E> {

        private int currentIndex = -1;

        private int expectModifyCount = modCount;

        @Override
        public boolean hasNext() {
            return currentIndex++ < size();
        }

        @Override
        public E next() {
            return (E) datas[currentIndex];
        }

        @Override
        public void remove() {
            if (expectModifyCount != modCount) {
                throw new ConcurrentModificationException();
            }
            MyArrayList_1.this.remove(datas[currentIndex]);
        }
    }
}
