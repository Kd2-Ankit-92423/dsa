
// ===========================================================================================
// 2. In singly linear linked list implement following operations. 
// i. insert a new node after a given data 
// ii.insert a new node before a given data
// ===========================================================================================


public class LinkedListOperations {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head;

    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public void insertAfter(int target, int newData) {
        Node current = head;

        while (current != null && current.data != target) {
            current = current.next;
        }
        if (current == null) {
            System.out.println("Node with data " + target + " not found!");
            return;
        }
        Node newNode = new Node(newData);
        newNode.next = current.next;
        current.next = newNode;
        
        System.out.println("Inserted " + newData + " after " + target);
    }

    public void insertBefore(int target, int newData) {
        if (head == null) return;
        if (head.data == target) {
            Node newNode = new Node(newData);
            newNode.next = head;
            head = newNode;
            System.out.println("Inserted " + newData + " before " + target + " (New Head)");
            return;
        }

        Node current = head;
        Node prev = null;

        while (current != null && current.data != target) {
            prev = current;       
            current = current.next; 
        }

        if (current == null) {
            System.out.println("Node with data " + target + " not found!");
            return;
        }

        Node newNode = new Node(newData);
        prev.next = newNode;
        newNode.next = current;
        
        System.out.println("Inserted " + newData + " before " + target);
    }

    public static void main(String[] args) {
        LinkedListOperations list = new LinkedListOperations();

        // 1. 10 -> 20 -> 30
        list.add(10);
        list.add(20);
        list.add(30);
        
        System.out.print("Original List: ");
        list.display();
        System.out.println("-----------------------------");

        // 2. Insert AFTER 20
        // We want: 10 -> 20 -> 25 -> 30
        list.insertAfter(20, 25);
        list.display();
        System.out.println("-----------------------------");

        // 3. Insert BEFORE 30
        // We want: 10 -> 20 -> 25 -> 28 -> 30
        list.insertBefore(30, 28);
        list.display();
        System.out.println("-----------------------------");

        // 4.Insert BEFORE Head (10)
        // We want: 5 -> 10 -> ...
        list.insertBefore(10, 5);
        list.display();
    }
}