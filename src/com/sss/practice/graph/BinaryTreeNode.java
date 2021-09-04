package com.sss.practice.graph;

public class BinaryTreeNode {
	public int data;
	public BinaryTreeNode left;
	public BinaryTreeNode right;

	public BinaryTreeNode(int item) {
		this.data = item;
		this.left = this.right = null;
	}
	
	public static void printPostorder(BinaryTreeNode root) {
		if (root == null) {
			return;
		}
		printPostorder(root.left);
		printPostorder(root.right);
		System.out.print(root.data + " ");
	}

	public static void printInorder(BinaryTreeNode root) {
		if (root == null) {
			return;
		}
		printInorder(root.left);
		System.out.print(root.data + " ");
		printInorder(root.right);
	}

	public static void printPreorder(BinaryTreeNode root) {
		if (root == null) {
			return;
		}
		System.out.print(root.data + " ");
		printPreorder(root.left);
		printPreorder(root.right);
	}

	@Override
	public String toString() {
		String str = "";
		if (left != null && right != null) {
			str = data + " [" + left + ", " + right + "]";
		}
		if (left == null) {
			str = data + " [, " + right + "]";
		}
		if (right == null) {
			str = data + " [" + left + ", ]";
		}
		if (left == null && right == null) {
			str = data+" ";
		}
		return str;
	}
}
