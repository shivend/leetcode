package com.sss.practice.amazon;


import com.sss.practice.graph.LinkedListNode;

public class MergeTwoLinkedList {
	public static LinkedListNode sortedMerge(LinkedListNode firstLinkedList, LinkedListNode secondLinkedList) {
		if (firstLinkedList == null) {
			return secondLinkedList;
		}
		if (secondLinkedList == null) {
			return firstLinkedList;
		}
		if (firstLinkedList.data < secondLinkedList.data) {
			firstLinkedList.next = sortedMerge(firstLinkedList.next, secondLinkedList);
			return firstLinkedList;
		} else {
			secondLinkedList.next = sortedMerge(firstLinkedList, secondLinkedList.next);
			return secondLinkedList;
		}
	}

	private static void reverseLinkedList(LinkedListNode node) {
		if (node == null) {
			return;
		}
		reverseLinkedList(node.next);
		System.out.print(node.data + " ");
	}

	public static void main(String[] args) {
		LinkedListNode firstLinkedList = new LinkedListNode(1);
		firstLinkedList.next = new LinkedListNode(2);
		firstLinkedList.next.next = new LinkedListNode(5);
		firstLinkedList.next.next.next = new LinkedListNode(7);
		LinkedListNode.traverseLinkedListNode(firstLinkedList);
		System.out.println();
		LinkedListNode secondLinkedList = new LinkedListNode(2);
		secondLinkedList.next = new LinkedListNode(4);
		secondLinkedList.next.next = new LinkedListNode(6);
		secondLinkedList.next.next.next = new LinkedListNode(8);
		LinkedListNode.traverseLinkedListNode(secondLinkedList);
		System.out.println();
		LinkedListNode newLinkedList = sortedMerge(firstLinkedList, secondLinkedList);
		LinkedListNode.traverseLinkedListNode(newLinkedList);
		System.out.println();
		reverseLinkedList(newLinkedList);
	}
}
