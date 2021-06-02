package com.brennan.ai;
import java.util.ArrayList;
import java.util.Collections;

public class Tree {

	Node root;
	
	public Tree() {
		root = null;
	}
	
	
	public void add(int data) { //same time complexity
		if( root == null ) {
			root = new Node(data);
		} else {
			addHelper(data, root);
		}
		
	}
	private void addHelper(int data, Node curr) { 
		
		if(curr == null ) {
			return;
		}
		/*
		if(data.compareTo(curr.data) <= 0) {
			if( curr.left == null ) { //add the new node if there isn't one there
				curr.left = new BSTNode<T>(data);
				return;
			}
			addHelper(data, curr.left); 
		} else {
			if(curr.right == null ) {
				curr.right = new BSTNode<T>(data);
				return;
			}
			addHelper(data, curr.right);
		}*/

	}
	
	
	public void preOrder() {
		preOrderHelper(root);
	}
	private void preOrderHelper(Node curr) { //O(n)
		if(curr != null) {
			System.out.println(curr.data); //C
			preOrderHelper(curr.left);  //L
			preOrderHelper(curr.right); //R
		}
	}
	
	
	public void clear() {
		root = null;
	}
	
	public boolean isEmpty() {
		if(root == null) {
			return true;
		}
		return false;
	}
	
	public int getDepth() {
		ArrayList<Integer> leafLvls = new ArrayList<Integer>();
		
		depthHelper(root, 0, leafLvls);
		Collections.sort(leafLvls);
		return leafLvls.get(leafLvls.size());
	}
	private void depthHelper(Node curr, int i, ArrayList<Integer> leafLvls) {
		if(curr.left != null) {
			depthHelper(curr.left, i+1, leafLvls);
		} 
		if(curr.right != null) {
			depthHelper(curr.right, i+1, leafLvls);
		} 
		if(curr.left == null && curr.right == null) { //if it's a leaf
			leafLvls.add(i);
		}
		
	}
	
	/*
	
	public void remove(T data) { //this finds the node I want to remove and its parent (Whole remove operation = O(log n), O(n) if unbalanced
		BSTNode<T> curr = root;
		BSTNode<T> parent = null; //the parent of the curr
		while(curr != null) {
			if(curr.data.compareTo(data) < 0) {
				parent = curr; //set parent to currs parent
				curr = curr.right; 
			}
			else if(curr.data.compareTo(data) > 0) {
				parent = curr;
				curr = curr.left;
			} else { //found the node
				removeNode(parent, curr);
				return;
			}
		}
		return;
		//didn't find it
		
	}
	
	private void removeNode(BSTNode<T> parent, BSTNode<T> removeMe) { //actually removes the node
		
		if(removeMe.left != null && removeMe.right != null) { //two children
			BSTNode<T> rML = removeMe.left;
			BSTNode<T> rMLParent = removeMe;
			while( rML.right != null) { //go one left then all the way right
				rMLParent = rML;
				rML = rML.right;
			}
			removeMe.data = rML.data;
			removeNode(rMLParent, rML); //call this method again. rML is sure to have only one child or no children (it will go to the else statement)
			return;
		} else { //zero or one child
			BSTNode<T> s = removeMe.left;
			if(s == null) {
				s = removeMe.right;
			}
			if(parent == null) { //if its asking to remove the root
				root = s;
			}
			else if(parent.left == removeMe) { //swap
				parent.left = s;
			} else {
				parent.right = s;
			}
			return;
		}
	}*/

	
}