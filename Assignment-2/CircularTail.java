// ===========================================================================================
// 1 . Implement singly circular linked list using tail pointer only (no head pointer). Compare time
//  complexities of all operations.
// ===========================================================================================
public class CircularTail {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    Node tail;
    public void addFirst(int data) {
        Node newNode = new Node(data);

        if (tail == null) {
            tail = newNode;
            tail.next = newNode; 
        } else {
            newNode.next = tail.next; 
            tail.next = newNode;  
        }
    }

    public void addLast(int data) {
        Node newNode = new Node(data);

        if (tail == null) {
            tail = newNode;
            tail.next = newNode;
        } else {
            newNode.next = tail.next; 
            tail.next = newNode;     
            tail = newNode;           
        }
    }

    public void deleteFirst() {
        if (tail == null) {
            System.out.println("List is empty.");
            return;
        }
        
        Node head = tail.next;
        
        if (head == tail) { 
            tail = null;
        } else {
            tail.next = head.next;
        }
        System.out.println("Deleted the first element.");
    }

    public void display() {
        if (tail == null) {
            System.out.println("List is empty");
            return;
        }

        Node head = tail.next;
        Node current = head;

        System.out.print("Circular List: ");
        do {
            System.out.print(current.data + " -> ");
            current = current.next;
        } while (current != head);
        
        System.out.println("(back to start)");
    }


    public static void main(String[] args) {
        CircularTail list = new CircularTail();

        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.display(); 

        list.addFirst(5);
        list.display(); 

        list.deleteFirst();
        list.display(); 
    }
}