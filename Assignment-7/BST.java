package BST;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BST {

	static class Node {
		private int data;
		private Node left;
		private Node right;
		
		public Node (int data) {
			this.data = data;
			left = right = null;
		}
	}
	public Node getroot() {
		return root;
	}
	private Node root;
	
	public BST() {
		root = null;
	}
	
	public void addNode (int data) {
		
		Node newNode = new Node(data);
		
		if(root == null) {
			root = newNode;
			return;
		}
		
		Node temp = root;
		
		while( true) {
			if(temp.data >data) {
				if(temp.left==null) {
					temp.left = newNode;
					break;
				}
				else {
					temp = temp.left;
				}
			}
			else {
				if(temp.right==null) {
					temp.right=newNode;
					break;
				}
				else {
					temp= temp.right;
				}
				
			}
	
		}
		
		
	}
	
	
	
	private  void addNode (int data,Node root) {
		
		if(root==null) {
			
			return ;
		}
			
		
		if(data<root.data) {
			if(root.left==null) {
				root.left = new Node(data);
				
			}
			else {
				addNode(data,root.left);
			}
			
		}
		else {
			
			if(root.right==null) {
				root.right = new Node(data);
				
			}
			else {
				addNode(data,root.right);
			}
		}
		
	}
	
	
	
	public void add(int data) {
		if(root==null) {
			Node newNode = new Node(data);
			root = newNode;
			return;
		}
		addNode(data,root);
	}
	
	private void PreOrder(Node root) {
		
		if(root==null) {
			return;
		}		
		System.out.print(" "+root.data);
		PreOrder(root.left);
		PreOrder(root.right);
		
	}
	
	public void Predorder() {
		PreOrder(root);
	}
	
	private void Inorder(Node root) {
		
		if(root==null) return;
		
		Inorder(root.left);
		System.out.print(" "+root.data);
		Inorder(root.right);
		
	}
	public void InOrder() {
		Inorder(root);
		System.out.println("");
	}
	
	private void PostOrder(Node root) {
		
		if(root==null) return;
		
		 PostOrder(root.left);
		 PostOrder(root.right);
		 System.out.print(" "+root.data);
	}
	
	public void PostOrder() {
		PostOrder(root);
	}
	
	
	public Node Search(int key) {
		
		Node temp = root;
		if(root==null) {
			return null;
		}
		else {
			
			while(temp!=null) {
				
				if(temp.data==key) {
					return temp;
				}
				else if(temp.data>key) {
					temp = temp.left;
				}
				else {
					temp= temp.right;
				}
				
			}
			return null;
		}
		
		
	}
	
	public Node Search(Node root ,int key) {
		
		if(root==null) {
			return null;
		}
		
		if(root.data == key) {
			return root;
		}
		else if(root.data>key) {
			return Search(root.left,key);
		}
		else {
			return Search(root.right,key);
		}
		
	}
	
	public int height(Node root) {
		
		if(root==null) {
			return -1;
		}
		int leftHeight = height(root.left);
		int rightHeight = height(root.right);
		
		int max = leftHeight > rightHeight ? leftHeight : rightHeight;
		
		return max+1;
		
	}
	
	public  int level (int key) {
		return level(root, key);
	}
		
	public int level(Node root, int key) {
	    return findLevel(root, key, 0);
	}

	private int findLevel(Node root, int key, int level) {
	    if (root == null) return -1;

	    if (root.data == key)
	        return level;

	    if (key < root.data)
	        return findLevel(root.left, key, level + 1);
	    else
	        return findLevel(root.right, key, level + 1);
	}

	public Node delete(int key) {
		root =  deleteNode(root,key);
		return root;
	}
	
	private  Node deleteNode(Node root,int key) {
		if(root==null) {
			return root;
		}
		if(root.data == key) {
			//0
				if(root.left==null && root.right ==null) {
					return null;
				}
			//1
				//left child
				if(root.right ==null && root.left!=null) {
					Node temp = root.left;
					return temp;
				}
				
				//right child
				
				if(root.left== null && root.right!=null) {
					Node temp = root.right;
					return temp;
				}		
			//2	
				if(root.left!=null && root.right!=null) {
					Node mintemp = findMin(root.right);
					root.data = mintemp.data;
					root.right = deleteNode(root.right,mintemp.data);
					return root;
				}
		}
		 if(root.data>key) {
			root.left = deleteNode(root.left, key);
			return root;
		}
		root.right = deleteNode(root.right, key);
		return root;

	}
	
	
	private Node findMin(Node root) {
		
		if(root.left ==null) {
			return root;
		}
		else{
			return findMin(root.left);
		}
	}
	
	public void dfs() {
		DFSTraversal(root);
	}
	
	private void DFSTraversal(Node root) {
		
		Stack<Node> st = new Stack<>();
		if(root==null) return;
		
		st.push(root);
		
		while(!st.isEmpty()) {
			Node temp = st.pop();
			System.out.print(" "+temp.data);
			if(temp.right!=null) {
				st.push(temp.right);
			}
			if(temp.left!=null) {
				st.push(temp.left);
			}
			
			
		}
		
		
		
	}
	
	public void BFS() {
		BFSTraversal(root);
	}
	
	private void BFSTraversal(Node root) {
		
		if(root==null) {
			return ;
		}
		
		Queue<Node> q = new ArrayDeque<>();
		
		q.offer(root);
		
		while(!q.isEmpty()) {
			
			Node temp = q.poll();
			System.out.print(" "+temp.data);
			
			if(temp.left!=null) {
				q.offer(temp.left);
			}
			if(temp.right!=null) {
				q.offer(temp.right);
			}
		}
		
		
	}
	
	public void print() {
		levelOrderPrint(root);
	}
	
	private void levelOrderPrint(Node root) {
		
		if(root ==null) return;
		System.out.println();
		System.out.println(" Printing tree : ");
		
		Queue<Node>q = new LinkedList<>();
		
		q.offer(root);
		
		q.offer(null);
		while(!q.isEmpty()) {
			
			Node temp = q.poll();
			if(temp == null) {
				System.out.println("");
				if(q.isEmpty()) {
					break;
				}
				q.offer(null);
			}
			else {
				
				System.out.print(" "+temp.data);
				
				if(temp.left!=null)
					q.offer(temp.left);
				if(temp.right!=null)
					q.offer(temp.right);
				
				
			}
			
			
			
		}
		
	}
	
	public void printSuccessor(int key) {
		
		Node temp = Search(key);
		if(temp==null){
			System.out.println("Null");
			return ;
		}
		successor(temp);
		
	}
	
	private Node successor(Node root) {
		
		Node trav = root.right;
		
		while(trav!=null && trav.left!=null  ) {
			
			trav= trav.left;
			
		}
		if(trav!=null) {
			System.out.println(trav.data);
		}
		else {
			System.out.println("Null");
		}
		
		return trav;
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
}
