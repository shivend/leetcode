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
		this.set = new LinkedHashSet<Integer>();
	}

	private void display() {
		LinkedList<Integer> list = new LinkedList<>(set);
		Iterator<Integer> itr = list.descendingIterator();
		while (itr.hasNext())
			System.out.print(itr.next() + " ");
	}

	private void refer(int key) {
		if (!set.contains(key)) {
			if (set.size() == capacity) {
				Integer temp = set.iterator().next();
				set.remove(temp);
			}
		}
		set.remove(key);
		set.add(key);
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
