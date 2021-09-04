package com.sss.practice.amazon;

import com.sss.practice.graph.LinkedListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;


public class MergeKSortedLinkedList {

	private static LinkedListNode mergeKSortedLinkedList(List<LinkedListNode> nodeList) {
		if (nodeList.isEmpty()) {
			return new LinkedListNode(null);
		}
		Queue<Integer> q = new PriorityQueue<Integer>();
		for (LinkedListNode l : nodeList) {
			while (l != null) {
				q.add(l.data);
				l = l.next;
			}
		}
		return queueToLinkedList(q);
	}

	private static LinkedListNode queueToLinkedList(Queue<Integer> q) {
		if (q.peek() != null) {
			LinkedListNode node = new LinkedListNode(q.poll());
			node.next = queueToLinkedList(q);
			return node;
		}
		return null;
	}

	public static void main(String[] args) {
		LinkedListNode l1 = new LinkedListNode(1);
		l1.next = new LinkedListNode(2);
		l1.next.next = new LinkedListNode(3);

		LinkedListNode l2 = new LinkedListNode(1);
		l2.next = new LinkedListNode(3);
		l2.next.next = new LinkedListNode(5);

		LinkedListNode l3 = new LinkedListNode(2);
		l3.next = new LinkedListNode(4);
		l3.next.next = new LinkedListNode(6);

		List<LinkedListNode> nodeList = new ArrayList<LinkedListNode>();
		nodeList.add(l1);
		nodeList.add(l2);
		nodeList.add(l3);
		
		LinkedListNode ans = mergeKSortedLinkedList(nodeList);
		LinkedListNode.traverseLinkedListNode(ans);
	}

}
