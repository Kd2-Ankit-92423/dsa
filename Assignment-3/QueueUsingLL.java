// ===========================================================================================
// 1. Implement stack and queue using linked list.
// ===========================================================================================
class QueueUsingLL {

    private static class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; }
    }

    private Node head;
    private Node tail;

    public void enqueue(int data) {
        Node newNode = new Node(data);
        
        if (tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode; 
            tail = newNode;      
        }
        System.out.println("Enqueued: " + data);
    }

    public int dequeue() {
        if (head == null) {
            System.out.println("Queue Underflow (Empty)");
            return -1;
        }
        int removedValue = head.data;
        head = head.next; 

        // Edge Case: If the queue becomes empty after removal
        if (head == null) {
            tail = null;
        }
        return removedValue;
    }

    public void display() {
        if (head == null) {
            System.out.println("Queue is Empty"); 
            return; 
        }
        Node temp = head;
        System.out.print("Queue (Front -> Rear): ");
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}