package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Stack {
    private ImmutableLinkedList stack = new ImmutableLinkedList();

    public void push(Object e) {
        stack = stack.add(e);
    }

    public Object pop() {
        Object obj = stack.get(stack.size() - 1);
        stack = stack.remove(stack.size() - 1);
        return obj;
    }

    public Object peek() {
        return stack.get(stack.size() - 1);
    }
}
