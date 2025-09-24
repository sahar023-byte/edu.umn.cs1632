package edu.umn.cs1632;

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.addItem(2);
        list.addItemAtEnd(4);
        list.addItemAtEnd(1);
        list.addItemAtEnd(3);
        list.showList();          // 2 4 1 3
        list.showReverseList();   // 3 1 4 2
    }
}
