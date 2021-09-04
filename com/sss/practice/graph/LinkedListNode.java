package com.sss.practice.graph;

public class LinkedListNode {
	public LinkedListNode next;
	public Integer data;
	
	public LinkedListNode(Integer data) {
		this.next = null;
		this.data = data;
	}
	
	public static void traverseLinkedListNode(LinkedListNode node) {
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
	}
}
