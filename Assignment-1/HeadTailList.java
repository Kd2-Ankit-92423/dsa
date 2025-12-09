/*
OPTIONAL
  4. Implement singly linked linked list using head and tail pointer.
  */

public class HeadTailList {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head;
    Node tail;

    public void addLast(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            tail = newNode; 
        } 

        else {
            tail.next = newNode; 
            tail = newNode;     
        }
        System.out.println("Added " + data + " to the end.");
    }

    public void addFirst(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        System.out.println("Added " + data + " to the start.");
    }

    public void display() {
        Node current = head;
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        System.out.print("Head (" + head.data + ") -> ");
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null ... Tail is (" + tail.data + ")");
    }

    public static void main(String[] args) {
        HeadTailList list = new HeadTailList();

        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.display();

        list.addFirst(5);

        list.display();
        
    }
}