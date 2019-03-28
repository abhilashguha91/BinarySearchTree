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
		
		//Inorder Traverse
		System.out.println("Pre Order Traverse");
		bstOperation.preOrderTraverse(root);
		
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
				if(value<root.value) {
					pointerNode = pointerNode.leftChild;
					if(pointerNode == null) {
						parent.leftChild = newNode;
						break;
					}
				}else if(value>root.value) {
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
	

}
