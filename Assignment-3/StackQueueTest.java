// ===========================================================================================
// 1. Implement stack and queue using linked list.
// ===========================================================================================


public class StackQueueTest {

    public static void main(String[] args) {
        
        System.out.println("=== TESTING STACK ===");
        StackUsingLL stack = new StackUsingLL();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.display();
        
        System.out.println("Popped: " + stack.pop()); 
        stack.display(); 

        System.out.println("\n=== TESTING QUEUE ===");
        QueueUsingLL queue = new QueueUsingLL();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.display();
        
        System.out.println("Dequeued: " + queue.dequeue()); 
        queue.display(); 
    }
}