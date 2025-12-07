// ===========================================================================================
// 4. Write program to implement linear queue in which front and rear starts at 0
// ===========================================================================================

import java.util.Scanner;

public class LinearQueueZero {

    int[] arr;
    int front;
    int rear;
    int capacity;

    public LinearQueueZero(int size) {
        this.capacity = size;
        this.arr = new int[size];
        this.front = 0;
        this.rear = 0;
    }

    public void enqueue(int data) {
        if (rear == capacity) {
            System.out.println(">> Queue is Full (Overflow)!");
            return;
        }
        arr[rear] = data;
        rear++;

        System.out.println(data + " enqueued.");
    }

    public void dequeue() {
        if (front == rear) {
            System.out.println(">> Queue is Empty (Underflow)!");
            return;
        }

        int removedValue = arr[front];
        arr[front] = 0;

        front++;

        System.out.println(removedValue + " dequeued.");
    }

    public void display() {
        if (front == rear) {
            System.out.println(">> Queue is Empty.");
            return;
        }

        System.out.print("Queue: Front[" + front + "] -> ");
        for (int i = front; i < rear; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("<- Rear[" + rear + "]");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Queue Size: ");
        int size = sc.nextInt();

        LinearQueueZero q = new LinearQueueZero(size);
        int choice;

        do {
            System.out.println("\n--- LINEAR QUEUE (Start at 0) ---");
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
                    q.enqueue(val);
                    break;
                case 2:
                    q.dequeue();
                    break;
                case 3:
                    q.display();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 0);

        sc.close();
    }
}
