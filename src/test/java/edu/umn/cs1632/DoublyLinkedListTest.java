package edu.umn.cs1632;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DoublyLinkedListTest {

    @Test
    @DisplayName("New list is empty and operations are safe")
    void emptyList() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        assertEquals(0, list.size());
        assertEquals("", list.toForwardString());
        assertEquals("", list.toReverseString());
        assertFalse(list.find(5));
        assertFalse(list.remove(5)); // removing missing value is safe
    }

    @Test
    @DisplayName("Add to front and end; forward/reverse order match")
    void addFrontAndEnd() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.addItem(2);          // front: 2
        list.addItemAtEnd(4);     // 2 4
        list.addItemAtEnd(1);     // 2 4 1
        list.addItemAtEnd(3);     // 2 4 1 3

        assertEquals("2 4 1 3", list.toForwardString());
        assertEquals("3 1 4 2", list.toReverseString());
        assertEquals(4, list.size());
        assertTrue(list.find(1));
        assertFalse(list.find(99));
    }

    @Test
    @DisplayName("Remove first occurrence: middle, head, tail, then to empty")
    void removeCases() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        // build: 2 4 1 3 1
        list.addItemAtEnd(2);
        list.addItemAtEnd(4);
        list.addItemAtEnd(1);
        list.addItemAtEnd(3);
        list.addItemAtEnd(1);

        assertTrue(list.remove(1));                 // remove first '1' (middle)
        assertEquals("2 4 3 1", list.toForwardString());

        assertTrue(list.remove(2));                 // remove head
        assertEquals("4 3 1", list.toForwardString());

        assertTrue(list.remove(1));                 // remove tail
        assertEquals("4 3", list.toForwardString());

        assertFalse(list.remove(42));               // not present

        assertTrue(list.remove(4));
        assertTrue(list.remove(3));                 // now empty
        assertEquals("", list.toForwardString());
        assertEquals("", list.toReverseString());
        assertEquals(0, list.size());
    }

    @Test
    @DisplayName("Works with non-integer data (Strings)")
    void worksWithStrings() {
        DoublyLinkedList<String> list = new DoublyLinkedList<>();
        list.addItem("a");
        list.addItemAtEnd("b");
        list.addItemAtEnd("c");
        assertTrue(list.find("b"));
        assertEquals("a b c", list.toForwardString());
        assertTrue(list.remove("b"));
        assertEquals("a c", list.toForwardString());
        assertEquals("c a", list.toReverseString());
    }
}
