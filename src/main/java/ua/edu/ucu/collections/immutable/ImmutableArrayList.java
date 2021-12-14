package ua.edu.ucu.collections.immutable;


import java.util.ArrayList;

public final class ImmutableArrayList implements ImmutableList {
    private ArrayList list;

    public ImmutableArrayList(Object[] elements) {
        list = new ArrayList<Object>();

        for (int i = 0; i < elements.length; i++) {
            list.add(elements[i]);
        }
    }

    public ImmutableArrayList() {
        list = new ArrayList<Object>();
    }

    @Override
    public ImmutableList add(Object e) {
        return add(size(), e);
    }

    @Override
    public ImmutableArrayList add(int index, Object e) {
        if (index < 0 || index > list.size()) {
            return null;
        }
        ArrayList newList = new ArrayList();
        for (int i = 0; i < list.size()+1; i++) {
            if (i == index) {
                newList.add(e);
            }
            if (i != list.size()) {
                newList.add(list.get(i));
            }
        }
        return new ImmutableArrayList(newList.toArray());
    }

    @Override
    public ImmutableArrayList addAll(Object[] c) {
        return addAll(list.size(), c);
    }

    @Override
    public ImmutableArrayList addAll(int index, Object[] c) {
        if (index < 0 || index > list.size()) {
            return null;
        }
        ArrayList newList = new ArrayList();
        for (int i = 0; i < list.size()+1; i++) {
            if (i == index) {
                for (int j = 0; j < c.length; j++) {
                    newList.add(c[j]);
                }
            }
            if (i != list.size()) {
                newList.add(list.get(i));
            }
        }
        return new ImmutableArrayList(newList.toArray());
    }

    @Override
    public Object get(int index) {
        return list.get(index);
    }

    @Override
    public ImmutableArrayList remove(int index) {
        if (size() == 0) {
            return null;
        }
        ArrayList newList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            if (i == index) {
            }
            else {
                newList.add(list.get(i));
            }
        }
        return new ImmutableArrayList(newList.toArray());
    }

    @Override
    public ImmutableArrayList set(int index, Object e) {
        if (size() == 0) {
            return null;
        }
        ArrayList newList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            if (i == index) {
                newList.add(e);
            }
            else {
                newList.add(list.get(i));
            }
        }
        return new ImmutableArrayList(newList.toArray());
    }

    @Override
    public int indexOf(Object e) {
        return list.indexOf(e);
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public ImmutableList clear() {
        return new ImmutableArrayList();
    }

    @Override
    public boolean isEmpty() {
        if (list.size() == 0) {
            return true;
        }
        return false;
    }

    @Override
    public Object[] toArray() {
        return list.toArray();
    }

    @Override
    public String toString() {
        if (size() == 0) {
            return "ImmutableArrayList{}";
        }
        String out = "ImmutableArrayList{";
        for (int i = 0; i < list.size()-1; i++) {
            out +=  list.get(i) + ", ";
        }
        out += list.get(list.size()-1) + "}";
        return out;
    }
}
