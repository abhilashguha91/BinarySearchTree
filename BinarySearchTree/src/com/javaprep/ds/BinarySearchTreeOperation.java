package com.javaprep.ds;

public class BinarySearchTreeOperation {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinarySearchTreeOperation bstOperation = new BinarySearchTreeOperation();
		Node root = null;
		
		int arr[] = {5,3,6,8,4,1,10,9,2,7};
		
		// TODO: open any one addition at a time.
		// Add nodes by iteration
		/*
		for(int i : arr) {
			root = bstOperation.addNewNode(root, i);
		}*/
		
		//Add nodes by recursion
		//bstOperation.addNodeByRecursion(root, arr[0]);
		for(int i=0; i<arr.length; i++) {
			root = bstOperation.addNodeByRecursion(root, arr[i]);	
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
		
		//Find node by recurtion
		Node n = bstOperation.findNodeByRecurtion(root,11);
		if(n !=null) {
			System.out.println("Node Found:"+ n.value);
		}else {
			System.out.println("Node not Found:");
		}
		
		// Minimum Node in the tree
		System.out.println("Mininum Node:" + bstOperation.getMinimumNodeFromTree(root).value);
		
		// Delete Node
		Node replacedNode = bstOperation.deleteNode(root, 7);
		if(replacedNode != null) {
			System.out.println("Node replaced by:"+replacedNode.value);
		}else {
			System.out.println("Node not found");
		}
		
		//Inorder Traverse
		System.out.println("Inorder Traverse");
		bstOperation.inorderTraverse(root);
		
	}
	
	Node addNewNode(Node root, int value) {
		
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
		return root;
	}
	
	public static Node addNodeByRecursion(Node root, int numberToBeInserted) {
		
		if (root == null) {
			Node nodeToBeInserted = new Node();
			nodeToBeInserted.value = numberToBeInserted;
			root = nodeToBeInserted;
			return root;
		}
		if (root.value > numberToBeInserted) {
			if (root.leftChild == null) {
				Node nodeToBeInserted = new Node();
				nodeToBeInserted.value = numberToBeInserted;
				root.leftChild = nodeToBeInserted;
			}
			else
				addNodeByRecursion(root.leftChild, numberToBeInserted);
		} else if (root.value < numberToBeInserted)
			if (root.rightChild == null) {
				Node nodeToBeInserted = new Node();
				nodeToBeInserted.value = numberToBeInserted;
				root.rightChild = nodeToBeInserted;
			}
			else
				addNodeByRecursion(root.rightChild, numberToBeInserted);
		return root;
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
	
	Node findNodeByIteration(Node root, int key) {
		
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
		
		if(root == null) return null; // not found
		if(key < root.value) root = findNodeByRecurtion(root.leftChild,key); // search on the left
		if(key > root.value) root = findNodeByRecurtion(root.rightChild, key); // search on the right
		return root; // This means the key has been found
		
	}
	
	Node deleteNode(Node root, int key) {
		
		if(root == null) return null; // not found
		else if(key<root.value) root.leftChild = deleteNode(root.leftChild, key); // search on the left
		else if(key>root.value) root.rightChild = deleteNode(root.rightChild, key); // search on the right
		else { // This means the key has been found
		
			// Case1: When this node has no children, i.e leaf node.
			if(root.leftChild == null && root.rightChild == null) {
				root = null;
			}// Case3: When this node has two children
			else if(root.rightChild != null && root.leftChild != null) {
				Node temp = root;
				Node minNodeFromRight = getMinimumNodeFromTree(root.rightChild);
				root.value = minNodeFromRight.value;
				deleteNode(root.rightChild, minNodeFromRight.value);
			}
			// Case2: When this node has only one child
			// If only left child
			else if(root.leftChild!=null) {
				root = root.leftChild;
			}// If only right child
			else if(root.rightChild!=null) {
				root = root.rightChild;
			}
			
			else {
				root = null;
			}
		}
		return root;
	}
	
	public Node getMinimumNodeFromTree(Node root) {
		if(root == null) return null;
		else if(root.leftChild == null) return root;
		else return getMinimumNodeFromTree(root.leftChild);
	}
	

}
