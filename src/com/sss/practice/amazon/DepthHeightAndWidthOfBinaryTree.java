package com.sss.practice.amazon;


import com.sss.practice.graph.BinaryTreeNode;

public class DepthHeightAndWidthOfBinaryTree {

	int findDepth(BinaryTreeNode node, int targetNode_data) {
		if (node == null)
			return -1;
		int dist = -1;
		if ((node.data == targetNode_data) || (dist = findDepth(node.left, targetNode_data)) >= 0
				|| (dist = findDepth(node.right, targetNode_data)) >= 0) {
			return dist + 1;
		}
		return dist;
	}

	int height = -1;

	int findHeightUtil(BinaryTreeNode node, int targetNode_data) {
		if (node == null) {
			return -1;
		}
		int leftHeight = findHeightUtil(node.left, targetNode_data);
		int rightHeight = findHeightUtil(node.right, targetNode_data);
		int ans = Math.max(leftHeight, rightHeight) + 1;
		if (node.data == targetNode_data) {
			height = ans;
		}
		return ans;
	}

	int findHeight(BinaryTreeNode node, int targetNode_data) {
		findHeightUtil(node, targetNode_data);
		return height;
	}

	int findWidth(BinaryTreeNode node) {
		int maxWidth = 0;
		int h = findHeightUtil(node, 7);
		for (int i = 0; i < h; i++) {
			int width = getWidth(node, i);
			if (width > maxWidth)
				maxWidth = width;
		}
		return  maxWidth;
	}

	private int getWidth(BinaryTreeNode node, int i) {
		if (node == null) {
			return 0;
		}
		if (i == 0) {
			return 1;
		} else {
			return getWidth(node.left, i - 1) + getWidth(node.right, i - 1);
		}
	}

	public static void main(String[] args) {
		BinaryTreeNode root = new BinaryTreeNode(8);
		root.left = new BinaryTreeNode(4);
		root.right = new BinaryTreeNode(9);
		root.left.right = new BinaryTreeNode(5);
		root.left.right.right = new BinaryTreeNode(6);
		root.left.right.right.right = new BinaryTreeNode(7);
		int k = 7;
		DepthHeightAndWidthOfBinaryTree obj = new DepthHeightAndWidthOfBinaryTree();
		System.out.println("Depth: " + obj.findDepth(root, k));
		System.out.println("Height: " + obj.findHeight(root, k));
		System.out.println("Width: " + obj.findWidth(root));
	}
}