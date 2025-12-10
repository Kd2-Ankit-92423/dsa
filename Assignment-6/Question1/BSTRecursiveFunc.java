package assignment6;

public class BSTRecursiveFunc {
	    static class Node {
	        int value;
	        Node left, right;

	        public Node(int value) {
	            this.value = value;
	            left = null;
	            right = null;
	        }
	    }

	    private Node root;
	  
	    public void insert(int value) {
	        root = insertRec(root, value);
	    }

	    
	    private Node insertRec(Node root, int value) {
	        if (root == null) {
	            return new Node(value);
	        }

	        if (value < root.value) {
	            root.left = insertRec(root.left, value);
	        } else if (value > root.value) {
	            root.right = insertRec(root.right, value);
	        }

	       
	        return root;
	    }

	   
	    public boolean search(int value) {
	        return searchRec(root, value);
	    }

	    private boolean searchRec(Node root, int value) {
	        if (root == null) {
	            return false;
	        }
	        if (root.value == value) {
	            return true;
	        }
	        return value < root.value ? searchRec(root.left, value) : searchRec(root.right, value);
	    }

	    public void delete(int value) {
	        root = deleteRec(root, value);
	    }

	    private Node deleteRec(Node root, int value) {
	        if (root == null) {
	            return null;
	        }

	        if (value < root.value) 
	        {
	            root.left = deleteRec(root.left, value);
	        } 
	        else if (value > root.value) 
	        {
	            root.right = deleteRec(root.right, value);
	        }
	        else
	        {

	            // Case 1: No child
	            if (root.left == null && root.right == null) {
	                return null;
	            }

	            // Case 2: One child
	            if (root.left == null) {
	                return root.right;
	            } else if (root.right == null) {
	                return root.left;
	            }

	            // Case 3: Two children
	            Node successor = minValueNode(root.right);
	            root.value = successor.value;

	            // Delete the inorder successor
	            root.right = deleteRec(root.right, successor.value);
	        }

	        return root;
	    }

	    // Helper to find minimum node
	    private Node minValueNode(Node node) {
	        Node current = node;
	        while (current.left != null) {
	            current = current.left;
	        }
	        return current;
	    }

	    
	    // Public method to get level of node
	    public int getLevel(int value) {
	        return getLevelRec(root, value, 1);   // start from level 1
	    }

	    // Recursive func to find level
	    private int getLevelRec(Node root, int value, int level) {
	        if (root == null) {
	            return -1;                      // value not found
	        }

	        if (root.value == value) {
	            return level;                   // found the node
	        }

	        // Search in left subtree
	        if (value < root.value) {
	            return getLevelRec(root.left, value, level + 1);
	        } 
	        // Search in right subtree
	        else {
	            return getLevelRec(root.right, value, level + 1);
	        }
	    }
	}