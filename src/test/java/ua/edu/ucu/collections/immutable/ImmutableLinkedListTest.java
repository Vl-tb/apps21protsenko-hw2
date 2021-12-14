package ua.edu.ucu.collections.immutable;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ImmutableLinkedListTest {
    Object[] nums = {7, 8};
    Object[] nums1 = {0, 0, 0};
    Object[] nums2 = {7, 6, 4, -7, 0};
    ImmutableLinkedList list = new ImmutableLinkedList(nums);
    ImmutableLinkedList list1 = new ImmutableLinkedList();
    ImmutableLinkedList list2 = new ImmutableLinkedList(nums2);

    @Test
    public void add() {
        Object[] obj = {1, 7, 8};
        Object[] obj1 = {5};
        Object[] obj2 = {7, 8, 9};
        assertArrayEquals(list.add(0, 1).toArray(), obj);
        assertArrayEquals(list1.add(5).toArray(), obj1);
        assertArrayEquals(list.add(9).toArray(), obj2);
    }

    @Test
    public void testAdd() {
        Object[] obj = {1};
        Object[] obj2 = {7, 8, 9};
        assertArrayEquals(list1.add(0, 1).toArray(), obj);
        assertEquals(list1.add(5, 1), null);
        assertArrayEquals(list.add(2, 9).toArray(), obj2);
        assertEquals(list.add(10, 9), null);
    }

    @Test
    public void addAll() {
        Object[] nums4 = {7, 8, 0, 0, 0};
        assertArrayEquals(list.addAll(nums1).toArray(), nums4);
    }

    @Test
    public void testAddAll() {
        Object[] nums4 = {7, 8, 0, 0, 0};
        assertArrayEquals(list.addAll(2, nums1).toArray(), nums4);
    }

    @Test
    public void get() {
        assertEquals(list.get(1), 8);
        assertEquals(list2.get(3), -7);
        assertEquals(list2.get(10), null);
    }

    @Test
    public void remove() {
        Object[] obj3 = {7, 4, -7, 0};
        assertEquals(list1.remove(10), null);
        assertEquals(list.remove(10), null);
        assertArrayEquals(list2.remove(1).toArray(), obj3);
    }

    @Test
    public void set() {
        Object[] obj1 = {5};
        Object[] obj2 = {7, 6, 4, -7, 5};
        assertArrayEquals(list1.set(0, 5).toArray(), obj1);
        assertEquals(list1.set(1, 5), null);
        assertEquals(list2.set(10, 5), null);
        assertArrayEquals(list2.set(4, 5).toArray(), obj2);
    }

    @Test
    public void indexOf() {
        assertEquals(list2.indexOf(4), 2);
        assertEquals(list2.indexOf(-1), -1);
        assertEquals(list2.indexOf(0), 4);
    }

    @Test
    public void size() {
        assertEquals(list2.size(), 5);
    }

    @Test
    public void clear() {
//        Object[] obj1 = {};
        assertEquals(list2.clear().size(), 0);
    }

    @Test
    public void isEmpty() {
        assertEquals(list2.isEmpty(), false);
        assertEquals(list1.isEmpty(), true);
    }

    @Test
    public void toArray() {
        Object[] obj1 = {7, 8};
        assertArrayEquals(list.toArray(), obj1);
    }

    @Test
    public void addFirst() {
        Object[] obj1 = {1, 7, 8};
        assertArrayEquals(list.addFirst(1).toArray(), obj1);
    }

    @Test
    public void addLast() {
        Object[] obj1 = {7, 8, 1};
        assertArrayEquals(list.addLast(1).toArray(), obj1);
    }

    @Test
    public void getHead() {
        assertEquals(list.getHead(), list.getHead());
    }

    @Test
    public void getTail() {
        assertEquals(list.getTail(), list.getTail());
    }

    @Test
    public void getFirst() {
        assertEquals(list.getFirst(), list.getHead());
    }

    @Test
    public void getLast() {
        assertEquals(list.getLast(), list.getTail());
    }

    @Test
    public void removeFirst() {
        Object[] obj3 = {6, 4, -7, 0};
        assertArrayEquals(list2.removeFirst().toArray(), obj3);
    }

    @Test
    public void removeLast() {
        Object[] obj3 = {7, 6, 4, -7};
        assertArrayEquals(list2.removeLast().toArray(), obj3);
    }

    @Test
    public void testToString() {
        assertEquals(list.toString(), "ImmutableLinkedList{head=7, tail=8}");
    }
}