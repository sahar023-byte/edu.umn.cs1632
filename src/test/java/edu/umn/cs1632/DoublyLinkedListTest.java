package edu.umn.cs1632;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DoublyLinkedListTest {

    @Test
    void emptyList() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        assertEquals(0, list.size());
        assertEquals("", list.toForwardString());
        assertEquals("", list.toReverseString());
        assertFalse(list.find(5));
        assertFalse(list.remove(5));
    }

    @Test
    void addFrontAndEnd() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.addItem(2);
        list.addItemAtEnd(4);
        list.addItemAtEnd(1);
        list.addItemAtEnd(3);
        assertEquals("2 4 1 3", list.toForwardString());
        assertEquals("3 1 4 2", list.toReverseString());
        assertTrue(list.find(1));
        assertFalse(list.find(99));
        assertEquals(4, list.size());
    }

    @Test
    void removeCases() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.addItemAtEnd(2);
        list.addItemAtEnd(4);
        list.addItemAtEnd(1);
        list.addItemAtEnd(3);
        list.addItemAtEnd(1);

        assertTrue(list.remove(1)); // middle
        assertEquals("2 4 3 1", list.toForwardString());

        assertTrue(list.remove(2)); // head
        assertEquals("4 3 1", list.toForwardString());

        assertTrue(list.remove(1)); // tail
        assertEquals("4 3", list.toForwardString());

        assertFalse(list.remove(42)); // not present

        assertTrue(list.remove(4));
        assertTrue(list.remove(3)); // empty
        assertEquals("", list.toForwardString());
        assertEquals(0, list.size());
    }

    @Test
    void stringsWorkToo() {
        DoublyLinkedList<String> list = new DoublyLinkedList<>();
        list.addItem("a");
        list.addItemAtEnd("b");
        list.addItemAtEnd("c");
        assertTrue(list.find("b"));
        assertTrue(list.remove("b"));
        assertEquals("a c", list.toForwardString());
        assertEquals("c a", list.toReverseString());
    }

    @Test
    void removeSingleItemList() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.addItemAtEnd(7);
        assertTrue(list.remove(7));
        assertEquals(0, list.size());
        assertEquals("", list.toForwardString());
    }

    @Test
    void longSequenceOrder() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        for (int i = 1; i <= 50; i++) list.addItemAtEnd(i);
        assertTrue(list.remove(1));   // head
        assertTrue(list.remove(25));  // middle
        assertTrue(list.remove(50));  // tail
        assertEquals(47, list.size());
        assertTrue(list.toForwardString().startsWith("2 3 4"));
        assertTrue(list.toForwardString().endsWith("47 48 49"));
    }
}
