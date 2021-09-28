package com.sss.practice.amazon;

import com.sss.practice.graph.LinkedListNode;

public class ReverseLinkedListWithoutRecursion {
    public static void main(String[] args) {
        LinkedListNode l1 = new LinkedListNode(9);
        l1.next = new LinkedListNode(8);
        l1.next.next = new LinkedListNode(7);
        l1.next.next.next = new LinkedListNode(6);
        l1.next.next.next.next = new LinkedListNode(5);
        l1.next.next.next.next.next = new LinkedListNode(4);
        LinkedListNode.traverseLinkedListNode(reverseLinkedList(l1));
    }

    private static LinkedListNode reverseLinkedList(LinkedListNode node) {
        LinkedListNode next = null;
        LinkedListNode prev = null;
        LinkedListNode current = node;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
}
