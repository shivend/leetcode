package com.sss.practice.amazon;


import com.sss.practice.graph.BinaryTreeNode;

public class DepthOfBinaryTree {

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

	public static void main(String[] args) {
		BinaryTreeNode root = new BinaryTreeNode(1);
		root.left = new BinaryTreeNode(2);
		root.right = new BinaryTreeNode(3);
		root.left.right = new BinaryTreeNode(4);
		root.left.right.right = new BinaryTreeNode(5);
		root.left.right.right.right = new BinaryTreeNode(6);

		int k = 6;
		DepthOfBinaryTree obj = new DepthOfBinaryTree();
		// Function call to find the
		// depth of a given node
		System.out.println("Depth: " + obj.findDepth(root, k));

		// Function call to find the
		// height of a given node
		System.out.println("Height: " + obj.findHeight(root, k));
	}
}