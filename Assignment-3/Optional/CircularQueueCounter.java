// ===========================================================================================
// 6. Implement circular queue using counter method
// ===========================================================================================

import java.util.Scanner;

public class CircularQueueCounter {

    int[] arr;
    int front;
    int rear;
    int count;
    int capacity;

    public CircularQueueCounter(int size) {
        this.capacity = size;
        this.arr = new int[size];
        this.front = 0;
        this.rear = -1;
        this.count = 0;
    }

    public void enqueue(int data) {
        if (count == capacity) {
            System.out.println(">> Queue is Full (Overflow)!");
            return;
        }
        rear = (rear + 1) % capacity;
        arr[rear] = data;
        count++;

        System.out.println("Enqueued: " + data);
    }

    public void dequeue() {
        if (count == 0) {
            System.out.println(">> Queue is Empty (Underflow)!");
            return;
        }
        int removedValue = arr[front];
        front = (front + 1) % capacity;
        count--;

        System.out.println("Dequeued: " + removedValue);
    }

    public void display() {
        if (count == 0) {
            System.out.println(">> Queue is Empty.");
            return;
        }

        System.out.print("Queue (" + count + " items): ");
        for (int i = 0; i < count; i++) {
            int index = (front + i) % capacity;
            System.out.print(arr[index] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Circular Queue Size: ");
        int size = sc.nextInt();

        CircularQueueCounter cq = new CircularQueueCounter(size);
        int choice;

        do {
            System.out.println("\n--- CIRCULAR QUEUE (Counter Method) ---");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Display");
            System.out.println("0. Exit");
            System.out.print("Choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value: ");
                    int val = sc.nextInt();
                    cq.enqueue(val);
                    break;
                case 2:
                    cq.dequeue();
                    break;
                case 3:
                    cq.display();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        } while (choice != 0);

        sc.close();
    }
}
