package com.sss.practice.amazon;


import com.sss.practice.graph.LinkedListNode;

public class AddTwoNumbers {

	public static void main(String[] args) {
		LinkedListNode l1 = new LinkedListNode(9);
		l1.next = new LinkedListNode(9);
		l1.next.next = new LinkedListNode(8);

		LinkedListNode l2 = new LinkedListNode(1);
		System.out.println(addTwoNumbers(l1, l2));
	}

	public static String addTwoNumbers(LinkedListNode l1, LinkedListNode l2) {
		String respString = "";
		int carry = 0;
		while (l1 != null || l2 != null) {
			int sum = (l1 != null ? l1.data : 0) + (l2 != null ? l2.data : 0) + carry;
			if (sum >= 10) {
				carry = 1;
				sum %= 10;
			} else {
				carry = 0;
			}
			respString += sum;
			l1 = l1 != null ? l1.next : null;
			l2 = l2 != null ? l2.next : null;
		}
		if (carry == 1) {
			respString += 1;
		}
		return respString;
	}

}
