package ua.edu.ucu.collections.immutable;

import java.util.ArrayList;

public final class ImmutableLinkedList implements ImmutableList {
    Node head;
    Node tail;

    public ImmutableLinkedList(Object[] elements) {
        ArrayList<Node> nodes = new ArrayList<>();

        for (int i = 0; i < elements.length; i++) {
            Node node = new Node();
            node.setValue(elements[i]);
            nodes.add(node);
        }
        if (nodes.size() != 1) {
            for (int i = 0; i < nodes.size() - 1; i++) {
                nodes.get(i).setNext(nodes.get(i+1));
                nodes.get(i+1).setPrevious(nodes.get(i));
            }
        }
        if (elements.length != 0) {
            head = nodes.get(0);
            tail = nodes.get(nodes.size() - 1);
        }
    }

    public ImmutableLinkedList() {
    }

    @Override
    public ImmutableLinkedList add(Object e) {
        if (head == null) {
            Object[] nodes = {e};
            return new ImmutableLinkedList(nodes);
        }
        int i = 0;
        Node curr = head;
        while(curr.getNext() != null) {
            i++;
            curr = curr.getNext();
        }
        return this.add(i+1, e);
    }

    @Override
    public ImmutableLinkedList add(int index, Object e) {
        if (head == null) {
            if (index == 0) {
                return this.add(e);
            }
            return null;
        }
        Node node = new Node();
        node.setValue(e);
        Node curr = head;
        ArrayList<Object> nodes = new ArrayList<>();
        int i = 0;
        boolean param = false;
        while(curr.getNext() != null) {
            if (i == index && !param) {
                nodes.add(e);
                param = true;
            }
            else {
                nodes.add(curr.getValue());
                i++;
                curr = curr.getNext();
            }
        }
        if (nodes.size() == i) {
            nodes.add(curr.getValue());
            nodes.add(e);
        }
        if (nodes.size() == i + 1) {
            nodes.add(curr.getValue());
        }
        if (index >= 0 && index <= i+1) {
            ImmutableLinkedList list = new ImmutableLinkedList(nodes.toArray());
            return list;
        }
        return null;

    }

    @Override
    public ImmutableLinkedList addAll(Object[] c) {
        return addAll(size(), c);
    }

    @Override
    public ImmutableLinkedList addAll(int index, Object[] c) {
        ImmutableLinkedList list = this;
        for (int i = 0; i < c.length; i++) {
            list = list.add((index + i), c[i]);
        }
        return list;
    }

    @Override
    public Object get(int index) {
        Node curr = head;
        int i = 0;
        while (curr.getNext() != null) {
            if (index == i) {
                return curr.getValue();
            }
            curr = curr.getNext();
            i++;
        }
        if (index == i) {
            return tail.getValue();
        }
        return null;
    }

    @Override
    public ImmutableLinkedList remove(int index) {
        Node curr = head;
        ArrayList<Object> nodes = new ArrayList<>();
        int i = 0;
        if (head == null) {
            return null;
        }
        while (curr.getNext() != null) {
            if (index == i) {
            }
            else {
                nodes.add(curr.getValue());
            }

            curr = curr.getNext();
            i++;
        }
        if (index < i && index > -1) {
            nodes.add(tail.getValue());
        }
        if (0> index || index > i){
            return null;
        }
        return new ImmutableLinkedList(nodes.toArray());
    }

    @Override
    public ImmutableLinkedList set(int index, Object e) {
        if (head == null && index == 0) {
            Object[] obj = {e};
            return new ImmutableLinkedList(obj);
        }
        if (head == null) {
            return null;
        }
        Node curr = head;
        ArrayList<Object> nodes = new ArrayList<>();
        int i = 0;
        while (curr.getNext() != null) {
            if (index == i) {
                nodes.add(e);
            }
            nodes.add(curr.getValue());
            curr = curr.getNext();
            i++;
        }
        if (index == i) {
            nodes.add(e);
        }
        if (0> index || index > i){
            return null;
        }
        return new ImmutableLinkedList(nodes.toArray());
    }

    @Override
    public int indexOf(Object e) {
        Node curr = head;
        int i = 0;
        while (curr.getNext() != null) {
            if (curr.getValue() == e) {
                return i;
            }
            i++;
            curr = curr.getNext();
        }
        if (tail.getValue() == e) {
            return i;
        }
        return -1;
    }

    @Override
    public int size() {
        if (head == null) {
            return 0;
        }
        Node curr = head;
        int i = 1;
        while (curr.getNext() != null) {
            i++;
            curr = curr.getNext();
        }
        return i;
    }

    @Override
    public ImmutableList clear() {
        return new ImmutableLinkedList();
    }

    @Override
    public boolean isEmpty() {
        if (head == null) {
            return true;
        }
        return false;
    }

    @Override
    public Object[] toArray() {
        Node curr = head;
        ArrayList<Object> nodes = new ArrayList<>();
        while (curr.getNext() != null) {
            nodes.add(curr.getValue());
            curr = curr.getNext();
        }
        nodes.add(getTail().getValue());
        return nodes.toArray();
    }

    public ImmutableLinkedList addFirst(Object e) {
        return add(0, e);
    }

    public ImmutableLinkedList addLast(Object e) {
        return add(size() - 1, e);
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public Object getFirst() {
        return head;
    }

    public Object getLast() {
        return tail;
    }

    public ImmutableLinkedList removeFirst() {
        return remove(0);
    }

    public ImmutableLinkedList removeLast() {
        return remove(size()-1);
    }

    @Override
    public String toString() {
        if (head == null) {
            return "ImmutableLinkedList{}";
        }
        String out = "ImmutableLinkedList{";
        Node curr = head;
        while (curr.getNext() != null) {
            if (curr == head) {
                out += "head=" + head;
            }
            else {
                out += ", " + curr.getValue();
            }
            curr = curr.getNext();
        }
        out += ", tail=" + tail + '}';
        return out;
    }
}
