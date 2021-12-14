package ua.edu.ucu.collections.immutable;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ImmutableArrayListTest {
    Object[] nums = {7, 8};
    Object[] nums1 = {1, 8, 4, 3, 0};
    ImmutableArrayList array = new ImmutableArrayList(nums);
    ImmutableArrayList array1 = new ImmutableArrayList();
    ImmutableArrayList array2 = new ImmutableArrayList(nums1);

    @Test
    public void add() {
        Object[] obj1 = {7, 8, 1};
        assertArrayEquals(array.add(1).toArray(), obj1);
    }

    @Test
    public void testAdd() {
        Object[] obj1 = {7, 1, 8};
        assertEquals(array.add(10, 0), null);
        assertArrayEquals(array.add(1, 1).toArray(), obj1);
    }

    @Test
    public void addAll() {
        Object[] obj1 = {7, 8, 1};
        Object[] obj2 = {7, 8, 7, 8, 1};
        assertArrayEquals(array.addAll(obj1).toArray(), obj2);
    }

    @Test
    public void testAddAll() {
        Object[] obj1 = {7, 8, 1};
        Object[] obj2 = {7, 8, 1, 7, 8};
        assertEquals(array.addAll(10, obj1), null);
        assertArrayEquals(array.addAll(0, obj1).toArray(), obj2);
    }

    @Test
    public void get() {
        assertEquals(array.get(1), 8);
    }

    @Test
    public void remove() {
        Object[] obj1 = {7};
        assertEquals(array1.remove(1), null);
        assertArrayEquals(array.remove(1).toArray(), obj1);
    }

    @Test
    public void set() {
        Object[] obj1 = {1, 8, 4, 6, 0};
        assertEquals(array1.set(0, 6), null);
        assertArrayEquals(array2.set(3, 6).toArray(), obj1);
    }

    @Test
    public void indexOf() {
        assertEquals(array2.indexOf(4), 2);
    }

    @Test
    public void size() {
        assertEquals(array2.size(), 5);
    }

    @Test
    public void clear() {
        assertEquals(array.clear().size(), 0);
    }

    @Test
    public void isEmpty() {
        assertEquals(array1.isEmpty(), true);
        assertEquals(array.isEmpty(), false);
    }

    @Test
    public void toArray() {
        Object[] obj1 = {7, 8};
        assertArrayEquals(array.toArray(), obj1);
    }

    @Test
    public void testToString() {
        assertEquals(array1.toString(), "ImmutableArrayList{}");
        assertEquals(array.toString(), "ImmutableArrayList{7, 8}");
    }
}