package com.javaprep.ds;

public class BinarySearchTreeOperation {
	
	
	static Node root = null;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinarySearchTreeOperation bstOperation = new BinarySearchTreeOperation();
		
		int arr[] = {5,3,6,8,4,1,10,9,2,7};
		for(int i : arr) {
			bstOperation.addNewNode(i);
		}
		
		//Inorder Traverse
		System.out.println("Inorder Traverse");
		bstOperation.inorderTraverse(root);
		
		//PreOrder Traverse
		System.out.println("Pre Order Traverse");
		bstOperation.preOrderTraverse(root);
		
		//PostOrder Traverse
		System.out.println("Post Order Traverse");
		bstOperation.postOrderTraverse(root);
		
		Node n = bstOperation.findNodeByRecurtion(root,11);
		if(n !=null) {
			System.out.println("Node Found:"+ n.value);
		}else {
			System.out.println("Node not Found:");
		}
		
	}
	
	void addNewNode(int value) {
		
		Node newNode = new Node();
		newNode.value = value;
		
		
		if(root==null) {
			root = newNode;
		}else {
			Node pointerNode = root;
			Node parent;
			while(true) {
				parent = pointerNode;
				if(value<pointerNode.value) {
					pointerNode = pointerNode.leftChild;
					if(pointerNode == null) {
						parent.leftChild = newNode;
						break;
					}
				}else if(value>pointerNode.value) {
					pointerNode = pointerNode.rightChild;
					if(pointerNode == null) {
						parent.rightChild = newNode;
						break;
					}
				}
			}
		}
	}
	
	void inorderTraverse(Node root) {
		
		if(root.leftChild!=null)
			inorderTraverse(root.leftChild);
		System.out.println(root.value);
		if(root.rightChild!=null)
			inorderTraverse(root.rightChild);
	}
	
	void preOrderTraverse(Node root) {
		
		System.out.println(root.value);
		if(root.leftChild!=null)
			preOrderTraverse(root.leftChild);
		if(root.rightChild!=null)
			preOrderTraverse(root.rightChild);
	}
	
	void postOrderTraverse(Node root) {
		
		if(root.leftChild!=null)
			preOrderTraverse(root.leftChild);
		if(root.rightChild!=null)
			preOrderTraverse(root.rightChild);
		System.out.println(root.value);
	}
	
	Node findNodeByIteration(int key) {
		
		Node pointer = root;
		while(pointer.value!=key) {
			if(key < pointer.value)
				pointer = pointer.leftChild;
			if(key > pointer.value)
				pointer = pointer.rightChild;
			if(pointer == null)
				return null;
		}
		return pointer;
		
	}
	
	Node findNodeByRecurtion(Node root, int key) {
		
		if(root == null) return null;
		if(key < root.value) root = findNodeByRecurtion(root.leftChild,key);
		if(key > root.value) root = findNodeByRecurtion(root.rightChild, key);
		return root;
		
	}
	

}
