package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Queue {
    private ImmutableLinkedList queue = new ImmutableLinkedList();

    public Object peek() {
        return queue.get(0);
    }

    public Object dequeue() {
        Object obj = queue.get(0);
        queue = queue.remove(0);
        return obj;
    }

    public void enqueue(Object e) {
        queue = queue.add(e);
    }
}
