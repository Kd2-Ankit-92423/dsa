package Assignment2.Assignment2_2;

class Node {
    int key;
    Node left, right;

    Node(int item) {
        key = item;
        left = right = null;
    }
}

class BST {
    Node root;

    // Function to return depth of a given key
    int getDepth(Node root, int key) {
        int depth = 0;
        Node current = root;

        while (current != null) {
            if (current.key == key) {
                return depth; // found the node
            } else if (key < current.key) {
                current = current.left;
            } else {
                current = current.right;
            }
            depth++;
        }
        return -1; // key not found
    }

    // Helper to call with root
    int getDepth(int key) {
        return getDepth(root, key);
    } 
}
public class Main {
    public static void main(String[] args) {
        BST tree = new BST();
        tree.root = new Node(10);
        tree.root.left = new Node(5);
        tree.root.right = new Node(15);
        tree.root.left.left = new Node(2);

        System.out.println("Depth of 10: " + tree.getDepth(10)); // 0
        System.out.println("Depth of 5: " + tree.getDepth(5));   // 1
        System.out.println("Depth of 2: " + tree.getDepth(2));   // 2
    }
}



