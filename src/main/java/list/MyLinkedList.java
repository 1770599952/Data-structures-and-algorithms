package list;

import java.util.Collection;
import java.util.Iterator;

public class MyLinkedList<E> implements Collection<E> {

    private Node pHead;
    private Node pTail;

    private static class Node<E> {
        private E data;
        private Node next;

        public Node() {

        }

        public Node(E data, Node next) {
            this.data = data;
            this.next = next;
        }

        public E getData() {
            return data;
        }

        public void setData(E data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return new MyLinkedListIterator();
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
        Node<E> newNode = new Node<E>(e, null);
        if (pHead == null) {
            pTail = pHead = newNode;
            return true;
        }
        pTail.next = newNode;
        pTail = newNode;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        Node cur = pHead;
        Node pPre = null;
        while (cur != null) {
            if (cur.data.equals(o)) {
                if (pPre == null) {
                    pHead = pHead.next;
                    return true;
                }
                pPre.next = cur.next;
                return true;
            }
            pPre = cur;
            cur = cur.next;
        }
        return false;
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

    public void printList() {
        Node cur = pHead;
        while (cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
    }

    private class MyLinkedListIterator implements Iterator<E> {

        private Node cur = pHead;
        private Node curPre = null;

        @Override
        public boolean hasNext() {
            return cur != null;
        }

        @Override
        public E next() {
            curPre = cur;
            cur = cur.next;
            return (E) curPre.data;
        }

        @Override
        public void remove() {
            MyLinkedList.this.remove(curPre.data);
        }
    }
}
