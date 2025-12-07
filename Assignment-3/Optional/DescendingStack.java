// ===========================================================================================
// 5. Write a program to implement descending stack. (Initialize top = SIZE)
// ===========================================================================================


import java.util.Scanner;

public class DescendingStack {

    int[] arr;
    int top;
    int capacity;

    public DescendingStack(int size) {
        this.capacity = size;
        this.arr = new int[size];
        this.top = size;
    }

    public void push(int data) {
        if (top == 0) {
            System.out.println(">> Stack Overflow (Full)");
            return;
        }

        top--; 
        arr[top] = data; 
        System.out.println("Pushed: " + data + " at index " + top);
    }

    public int pop() {
        if (top == capacity) {
            System.out.println(">> Stack Underflow (Empty)");
            return -1;
        }

        int value = arr[top];
        System.out.println("Popped: " + value + " from index " + top);
        top++; 
        return value;
    }

    public int peek() {
        if (top == capacity) {
            System.out.println("Stack is Empty");
            return -1;
        }
        return arr[top];
    }
    public void display() {
        if (top == capacity) {
            System.out.println("Stack is Empty");
            return;
        }

        System.out.print("Stack (Top -> Bottom): ");
        for (int i = top; i < capacity; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Stack Size: ");
        int size = sc.nextInt();

        DescendingStack stack = new DescendingStack(size);
        int choice;

        do {
            System.out.println("\n--- DESCENDING STACK (Top = " + size + ") ---");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Display");
            System.out.println("0. Exit");
            System.out.print("Choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value: ");
                    int val = sc.nextInt();
                    stack.push(val);
                    break;
                case 2:
                    stack.pop();
                    break;
                case 3:
                    stack.display();
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