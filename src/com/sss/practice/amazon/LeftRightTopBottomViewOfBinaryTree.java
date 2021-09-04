package com.sss.practice.amazon;

import com.sss.practice.graph.BinaryTreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;

class Max_level {
    int max_level;
}

class BinaryTreeNodeQueue {
	BinaryTreeNode node;
	Integer hq;
	
	public BinaryTreeNodeQueue(BinaryTreeNode node, Integer hq) {
		this.node = node;
		this.hq = hq;
	}
}

public class LeftRightTopBottomViewOfBinaryTree {
	private static void printLeftViewBinaryTree(BinaryTreeNode node, Integer level, Max_level max_level) {
		if (node == null) {
			return;
		}
		if (max_level.max_level < level) {
			System.out.print(node.data + " ");
			max_level.max_level = level;
		}
		printLeftViewBinaryTree(node.left, level + 1, max_level);
		printLeftViewBinaryTree(node.right, level + 1, max_level);
	}

	private static void printRightViewBinaryTree(BinaryTreeNode node, Integer level,  Max_level max_level) {
		if (node == null) {
			return;
		}
		if (max_level.max_level < level) {
			System.out.print(node.data + " ");
			max_level.max_level = level;
		}
		printRightViewBinaryTree(node.right, level + 1, max_level);
		printRightViewBinaryTree(node.left, level + 1, max_level);
	}
	
	private static void printTopViewBinaryTree(BinaryTreeNode node) {
		if (node == null) {
			return;
		}
		Queue<BinaryTreeNodeQueue> q = new LinkedList<BinaryTreeNodeQueue>();
		Map<Integer, BinaryTreeNode> topViewMap = new HashMap<Integer, BinaryTreeNode>();
		q.add(new BinaryTreeNodeQueue(node, 0));
		while (!q.isEmpty()) {
			BinaryTreeNodeQueue nodeFromQ = q.poll();
			if (!topViewMap.containsKey(nodeFromQ.hq)) {
				topViewMap.put(nodeFromQ.hq, nodeFromQ.node);
			}
			if (nodeFromQ.node.left != null) {
				q.add(new BinaryTreeNodeQueue(nodeFromQ.node.left, nodeFromQ.hq - 1));
			}
			if (nodeFromQ.node.right != null) {
				q.add(new BinaryTreeNodeQueue(nodeFromQ.node.right, nodeFromQ.hq + 1));
			}
		}
		for (Entry<Integer, BinaryTreeNode> entry : topViewMap.entrySet()) {
			System.out.print(entry.getValue().data + " ");
		}
	}
	
	private static void printBottomViewBinaryTree(BinaryTreeNode node) {
		if (node == null) {
			return;
		}
		Queue<BinaryTreeNodeQueue> q = new LinkedList<BinaryTreeNodeQueue>();
		Map<Integer, BinaryTreeNode> topViewMap = new HashMap<Integer, BinaryTreeNode>();
		q.add(new BinaryTreeNodeQueue(node, 0));
		while (!q.isEmpty()) {
			BinaryTreeNodeQueue nodeFromQ = q.poll();
			topViewMap.put(nodeFromQ.hq, nodeFromQ.node);
			if (nodeFromQ.node.left != null) {
				q.add(new BinaryTreeNodeQueue(nodeFromQ.node.left, nodeFromQ.hq - 1));
			}
			if (nodeFromQ.node.right != null) {
				q.add(new BinaryTreeNodeQueue(nodeFromQ.node.right, nodeFromQ.hq + 1));
			}
		}
		for (Entry<Integer, BinaryTreeNode> entry : topViewMap.entrySet()) {
			System.out.print(entry.getValue().data + " ");
		}
	}
	/* Create following Binary Tree
					 1
					/ \
					2 3
					\
					 4
					  \
					   5
						\
						 6
	*/
	
	public static void main(String[] args) {
		BinaryTreeNode root = new BinaryTreeNode(1);
		root.left = new BinaryTreeNode(2);
		root.right = new BinaryTreeNode(3);
		root.left.right = new BinaryTreeNode(4);
		root.left.right.right = new BinaryTreeNode(5);
		root.left.right.right.right = new BinaryTreeNode(6);
		System.out.print("Left View: ");
		printLeftViewBinaryTree(root, 1, new Max_level());
		System.out.println();
		System.out.print("Right View: ");
		printRightViewBinaryTree(root, 1, new Max_level());
		System.out.println();
		System.out.print("Top View: ");
		printTopViewBinaryTree(root);
		System.out.println();
		System.out.print("Bottom View: ");
		printBottomViewBinaryTree(root);
	}
}


