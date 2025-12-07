// ===========================================================================================
// 1. Implement stack and queue using linked list.
// ===========================================================================================
class StackUsingLL {

    private static class Node {
        int data;
        Node next;
        Node(int data) { 
            this.data = data;
         }
    }

    private Node head;

    public void push(int data) {
        Node newNode = new Node(data);
        newNode.next = head; 
        head = newNode;      
        System.out.println("Pushed: " + data);
    }

    public int pop() {
        if (head == null) {
            System.out.println("Stack Underflow (Empty)");
            return -1;
        }
        int poppedValue = head.data;
        head = head.next; 
        return poppedValue;
    }

    public int peek() {
        if (head == null) {
            System.out.println("Stack is Empty");
            return -1;
        }
        return head.data;
    }

    public void display() {
        if (head == null) {
            System.out.println("Stack is Empty"); 
            return; 
        }
        Node temp = head;
        System.out.print("Stack (Top -> Bottom): ");
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}