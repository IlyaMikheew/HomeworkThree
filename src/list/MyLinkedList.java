package list;

import java.util.Iterator;
import java.util.NoSuchElementException;


public class MyLinkedList <E> implements ILinkedList<E> {
    private Node<E> begin = null;
    private Node<E> end = null;
    private int size = 0;


    private static class Node<E> {
        private E elem;
        private Node<E> next = null;

        public Node(E elem){
            this.elem = elem;
        }
    }

    private class MyIterator implements Iterator<E> {
        Node<E> nextNode = begin;
        Node<E> previous;
        Node<E> current = null;
        private boolean isRemoveAvailable = false;

        public MyIterator () {
        }

        @Override
        public boolean hasNext(){
            return nextNode != null;
        }

        @Override
        public E next() {
            if(!hasNext()) throw new NoSuchElementException();

            previous = current;
            current = nextNode;
            nextNode = nextNode.next;
            isRemoveAvailable = true;
            return current.elem;
        }

        @Override
        public void remove() {
            if(!isRemoveAvailable) throw new IllegalStateException();
            if(previous == null) {
                begin = nextNode;
            } else {
                previous.next = nextNode;
            }
            current.elem = null;
            current.next = null;
            isRemoveAvailable = false;
            current = previous;
            previous = null;
            size--;
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new MyIterator();
    }

    @Override
    public void add(E element) {
        Node<E> newNode = new Node<>(element);
        if(begin == null){
            begin = newNode;
        }
        else {
            end.next = newNode;
        }
        end = newNode;
        size++;
    }

    @Override
    public void add(int index, E element) {
        if (index > size || index < 0) throw new IndexOutOfBoundsException();
        if (index == size) {
            add(element);
            return;
        }
        Node<E> newNode = new Node<>(element);
        Node<E> previous = begin;
        Node<E> next;
        if (index == 0){
            newNode.next = begin;
            begin = newNode;
            size++;
            return;
        }
        for (int i = 0; i < index - 1; i++){
            previous = previous.next;
        }
        next = previous.next;
        previous.next = newNode;
        newNode.next = next;
        size++;
    }

    @Override
    public void clear() {
        Node<E> next;
        while(begin!=null){
            begin.elem = null;
            next = begin.next;
            begin.next = null;
            begin = next;
        }
        end = null;
        size = 0;
    }

    @Override
    public E get(int index) {
        if (index > size || index < 0) throw new IndexOutOfBoundsException();
        Node<E> current = begin;
        for (int i = 0; i < index; i++){
            current = current.next;
        }
        return current.elem;
    }

    @Override
    public int indexOf(E element) {
        int result = 0;
        Node<E> current = begin;
        if(element != null) {
            while (current != null) {
                if (current.elem.equals(element)) {
                    return result;
                }
                result++;
                current = current.next;
            }
        } else {
            while (current != null) {
                if (current.elem == null) {
                    return result;
                }
                result++;
                current = current.next;
            }
        }
        return -1;
    }

    @Override
    public E remove(int index) {
        if (index >= size || index < 0) throw new IndexOutOfBoundsException();
        E result;
        Node<E> previous = begin;
        Node<E> next;
        if(index == 0){
            result = begin.elem;
            begin = begin.next;
            previous.elem = null;
            previous.next = null;
            size--;
            return result;
        }
        for(int i = 0; i < index-1; i++){
            previous = previous.next;
        }
        if(index == size - 1){
            result = end.elem;
            end.elem = null;
            end = previous;
            end.next = null;
            size--;
            return result;
        }
        next = previous.next;
        result = next.elem;
        previous.next = next.next;
        next.elem = null;
        next.next = null;
        size--;
        return result;
    }

    @Override
    public E set(int index, E element) {
        if (index > size || index < 0) throw new IndexOutOfBoundsException();
        E result;
        Node<E> current = begin;
        for (int i = 0; i < index; i++){
            current = current.next;
        }
        result = current.elem;
        current.elem = element;
        return result;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        if (a.length < size) {
            a = (T[]) java.lang.reflect.Array.newInstance(a.getClass().getComponentType(), size);
        }
        int i = 0;
        Object[] result = a;
        for (MyLinkedList.Node<E> x = begin; x != null; x = x.next)
            result[i++] = x.elem;

        if (a.length > size)
            a[size] = null;

        return a;
    }

    @Override
    public String toString(){
        if(size == 0) return "{}";
        Node<E> current = begin;
        StringBuilder result = new StringBuilder();
        result.append("{ ");
        result.append(current.elem);
        current = current.next;
        while(current != null){
            result.append(", ");
            result.append(current.elem);
            current = current.next;
        }
        result.append(" }");
        return result.toString();
    }
}
