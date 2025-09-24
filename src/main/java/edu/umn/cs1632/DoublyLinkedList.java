package edu.umn.cs1632;

import java.util.Objects;

public class DoublyLinkedList<T> {

    private static final class Node<T> {
        T data; Node<T> next; Node<T> prev;
        Node(T d) { this.data = d; }
    }

    private Node<T> head, tail;
    private int size;

    // add to front
    public void addItem(T value) {
        Node<T> n = new Node<>(value);
        n.next = head;
        if (head != null) head.prev = n; else tail = n;
        head = n; size++;
    }

    // append to end
    public void addItemAtEnd(T value) {
        Node<T> n = new Node<>(value);
        n.prev = tail;
        if (tail != null) tail.next = n; else head = n;
        tail = n; size++;
    }

    public boolean find(T value) { return findNode(value) != null; }

    // remove first occurrence
    public boolean remove(T value) {
        Node<T> t = findNode(value);
        if (t == null) return false;
        Node<T> p = t.prev, q = t.next;
        if (p != null) p.next = q; else head = q;
        if (q != null) q.prev = p; else tail = p;
        size--; return true;
    }

    public void showList() { System.out.println(toForwardString()); }
    public void showReverseList() { System.out.println(toReverseString()); }

    public String toForwardString() {
        StringBuilder sb = new StringBuilder();
        for (Node<T> c = head; c != null; c = c.next) {
            if (sb.length() > 0) sb.append(' ');
            sb.append(c.data);
        }
        return sb.toString();
    }

    public String toReverseString() {
        StringBuilder sb = new StringBuilder();
        for (Node<T> c = tail; c != null; c = c.prev) {
            if (sb.length() > 0) sb.append(' ');
            sb.append(c.data);
        }
        return sb.toString();
    }

    public int size() { return size; }

    private Node<T> findNode(T value) {
        for (Node<T> c = head; c != null; c = c.next)
            if (Objects.equals(c.data, value)) return c;
        return null;
    }
}
