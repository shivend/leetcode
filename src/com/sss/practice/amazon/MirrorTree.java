package com.sss.practice.amazon;

import com.sss.practice.graph.BinaryTreeNode;

public class MirrorTree {

	private static BinaryTreeNode mirrorTree(BinaryTreeNode node) {
		if (node == null)
			return node;
		BinaryTreeNode left = mirrorTree(node.left);
		BinaryTreeNode right = mirrorTree(node.right);
		node.left = right;
		node.right = left;
		return node;
	}

	public static void main(String[] args) {
		BinaryTreeNode root = new BinaryTreeNode(50);
		root.left = new BinaryTreeNode(30);
		root.right = new BinaryTreeNode(60);
		root.left.left = new BinaryTreeNode(20);
		root.left.right = new BinaryTreeNode(40);
		System.out.println(root);
		BinaryTreeNode newNode = mirrorTree(root);
		System.out.println(newNode);
		BinaryTreeNode.printPreorder(newNode);
		System.out.println();
		BinaryTreeNode.printInorder(newNode);
	}
}
