package com.sss.practice.amazon;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Set;

public class LRUCache {
    private final Integer capacity;
    private Set<Integer> set;

    public LRUCache(Integer capacity) {
        super();
        this.capacity = capacity;
        this.set = new LinkedHashSet<>();
    }

    private void refer(int key) {
        if (!set.contains(key) && set.size() == capacity) {
            set.remove(set.iterator().next());
        } else {
            set.remove(key);
        }
        set.add(key);
    }

    private void display() {
        LinkedList<Integer> list = new LinkedList<>(set);
        Iterator<Integer> itr = list.descendingIterator();
        while (itr.hasNext())
            System.out.print(itr.next() + " ");
    }

    public static void main(String[] args) {
        LRUCache ca = new LRUCache(4);
        ca.refer(1);
        ca.refer(2);
        ca.refer(3);
        ca.refer(1);
        ca.refer(4);
        ca.refer(5);
        ca.display();
    }
}
